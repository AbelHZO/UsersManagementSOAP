package com.abelhzo.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.RolesJAX;

@WebService(name = "RolesServiceSOAP", targetNamespace = "http://abelhzo.roles/")
public interface RolService {

	@WebMethod(operationName = "saveRolSOAP")
	@WebResult(name = "RolRS")
	public ResponseWrapper<RolesJAX.RolRS> saveRol(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "RolesAddRQ") @XmlElement(required = true) RolesJAX.RolesAddRQ rq);

	@WebMethod(operationName = "updateRolSOAP")
	@WebResult(name = "RolRS")
	public ResponseWrapper<RolesJAX.RolRS> updateRol(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "RolesUpdateRQ") @XmlElement(required = true) RolesJAX.RolesUpdateRQ rq);

	@WebMethod(operationName = "getRolSOAP")
	@WebResult(name = "RolRS")
	public ResponseWrapper<RolesJAX.RolRS> getRol(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "idRol") @XmlElement(required = true) Long idRol);

	@WebMethod(operationName = "listRolSOAP")
	@WebResult(name = "RolRS")
	public ResponseWrapper<RolesJAX.RolRS> listRol(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config);

}
