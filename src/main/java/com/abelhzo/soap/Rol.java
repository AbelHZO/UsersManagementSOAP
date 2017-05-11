package com.abelhzo.soap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.abelhzo.soap.bo.services.RolesServiceBO;
import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.RolesJAX;
import com.abelhzo.soap.service.RolService;

@WebService(serviceName = "RolesServiceSOAP", 
			portName = "RolesServicePortSOAP", 
			endpointInterface = "com.abelhzo.soap.service.RolService", 
			targetNamespace = "http://abelhzo.roles/")
public class Rol extends SpringBeanAutowiringSupport implements RolService {

	@Autowired
	private RolesServiceBO rolesServicesBO;

	@Override
	public ResponseWrapper<RolesJAX.RolRS> saveRol(ConfigJAX config, RolesJAX.RolesAddRQ rq) {
		return rolesServicesBO.saveRol(config, rq);
	}

	@Override
	public ResponseWrapper<RolesJAX.RolRS> updateRol(ConfigJAX config, RolesJAX.RolesUpdateRQ rq) {
		return rolesServicesBO.updateRol(config, rq);
	}

	@Override
	public ResponseWrapper<RolesJAX.RolRS> getRol(ConfigJAX config, Long idrol) {
		return rolesServicesBO.getRol(config, idrol);
	}

	@Override
	public ResponseWrapper<RolesJAX.RolRS> listRol(ConfigJAX config) {
		return rolesServicesBO.listRol(config);
	}

}
