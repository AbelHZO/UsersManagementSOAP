package com.abelhzo.soap.messages;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.abelhzo.soap.jaxws.MessageJAX;

@Component
public class MessagesFactory {
	
	public MessageJAX successResult(String description) {
		return new MessageJAX(Codes.SUCCESS, 
							  Codes.BUSSINES, 
				              new Timestamp(new Date().getTime()), 
				              Codes.CRITICALITY_INFO, 
				              description);
	}
	
	public MessageJAX notFoundResult(String description) {
		return new MessageJAX(Codes.EMPTY, 
							  Codes.BUSSINES, 
						      new Timestamp(new Date().getTime()), 
						      Codes.CRITICALITY_INFO, 
						      description);
	}
	
	public MessageJAX loginError(String description) {
		return new MessageJAX(Codes.ERRORLOGIN, 
							  Codes.BUSSINES, 
							  new Timestamp(new Date().getTime()), 
							  Codes.CRITICALITY_INFO, 
							  description);
	}
	
	public MessageJAX sessionActive(String description) {
		return new MessageJAX(Codes.SESSIONACTIVE, 
				              Codes.BUSSINES, 
				              new Timestamp(new Date().getTime()), 
				              Codes.CRITICALITY_INFO, 
				              description);
	}
	
	public MessageJAX userIncorrect(String description) {
		return new MessageJAX(Codes.ERRORUSER, 
							  Codes.BUSSINES, 
							  new Timestamp(new Date().getTime()), 
							  Codes.CRITICALITY_WARN, 
							  description);
	}
	
	public MessageJAX errorInsert(String description) {
		return new MessageJAX(Codes.OPERATION, 
							  Codes.TECNICAL, 
							  new Timestamp(new Date().getTime()), 
							  Codes.CRITICALITY_FATAL, 
							  description);
	}
	
	public MessageJAX errorUpdate(String description) {
		return new MessageJAX(Codes.ERRORPARAMS, 
							  Codes.BUSSINES, 
							  new Timestamp(new Date().getTime()), 
							  Codes.CRITICALITY_ERROR, 
							  description);
	}
	
	public MessageJAX errorParams(String description) {
		return new MessageJAX(Codes.ERRORPARAMS, 
							  Codes.TECNICAL, 
							  new Timestamp(new Date().getTime()), 
							  Codes.CRITICALITY_FATAL, 
							  description);
	}
	
	public MessageJAX errorException(String description) {
		return new MessageJAX(Codes.EXCEPTION, 
							  Codes.TECNICAL, 
							  new Timestamp(new Date().getTime()), 
							  Codes.CRITICALITY_FATAL, 
							  description);
	}

}
