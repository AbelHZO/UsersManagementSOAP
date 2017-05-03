package com.abelhzo.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.UserJAX;

@WebService(name = "UsersServiceSOAP", targetNamespace = "http://abelhzo.users/")
public interface UserService {

	@WebMethod(operationName = "saveUserSOAP")
	@WebResult(name = "UserRS")
	public ResponseWrapper<UserJAX.UserRS> saveUser(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "UserAddRQ") @XmlElement(required = true) UserJAX.UserAddRQ rq);

	@WebMethod(operationName = "updateUserSOAP")
	@WebResult(name = "UserRS")
	public ResponseWrapper<UserJAX.UserRS> updateUser(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "UserUpdateRQ") @XmlElement(required = true) UserJAX.UserUpdateRQ rq);

	@WebMethod(operationName = "getUserSOAP")
	@WebResult(name = "UserRS")
	public ResponseWrapper<UserJAX.UserRS> getUser(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "iduser") @XmlElement(required = true) Long idUser);

	@WebMethod(operationName = "listUserSOAP")
	@WebResult(name = "UserRS")
	public ResponseWrapper<UserJAX.UserRS> listUsers(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config);

	@WebMethod(operationName = "loginUserSOAP")
	@WebResult(name = "UserRS")
	public ResponseWrapper<UserJAX.UserRS> loginUser(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "UserLoginRQ") @XmlElement(required = true) UserJAX.UserLoginRQ rq);

	@WebMethod(operationName = "logoutUserSOAP")
	@WebResult(name = "UserRS")
	public ResponseWrapper<UserJAX.UserRS> logoutUser(
			@WebParam(name = "ConfigJAX") @XmlElement(required = true) ConfigJAX config,
			@WebParam(name = "UserLogoutRQ") @XmlElement(required = true) UserJAX.UserLogoutRQ rq);

}
