package com.abelhzo.soap.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.MessageItemJAX;
import com.abelhzo.soap.messages.Codes;
import com.abelhzo.soap.messages.MessagesFactory;

@Component
@Aspect
public class Validateconfig {

	@Autowired
	private MessagesFactory messagesFactory;

	@Around("(execution(* com.abelhzo.soap.bo.*.*(..))) && "
		  + "@annotation(com.abelhzo.soap.annotations.Validateconfig)")
	public Object aroundRequest(ProceedingJoinPoint pjp)
			throws java.lang.InstantiationException, java.lang.IllegalAccessException {

		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method method = ms.getMethod();
		
		Object messageItem = method.getReturnType().newInstance();

		ConfigJAX configjax = null;

		for (Object param : pjp.getArgs()) {
			if (param instanceof ConfigJAX) {
				configjax = (ConfigJAX) param;
				break;
			}
		}

		if (configjax == null || 
			configjax.getIduser() == null ||
			configjax.getIp() == null ||
			configjax.getLanguage() == null ||
		    configjax.getIduser().equals("") ||
		    configjax.getIp().equals("")) {

			((MessageItemJAX) messageItem).setStatus(Codes.KO);
			((MessageItemJAX) messageItem).getMessage().add(messagesFactory.errorParams("ERROR EN LOS PARAMETROS DE CONFIGURACIÓN"));

			return messageItem;

		} else {
			try {
				return pjp.proceed();
			} catch (Throwable e) {
				
				if(e instanceof DataIntegrityViolationException) {
					DataIntegrityViolationException dive = (DataIntegrityViolationException) e;
					((MessageItemJAX) messageItem).setStatus(Codes.KO);
					((MessageItemJAX) messageItem).getMessage().add(messagesFactory.errorParams("ERROR EN LA CONSULTA: " + dive.getRootCause() + " - " + dive.getMessage()));
				}

			}
			
			return messageItem;
		}

	}

}
