package com.abelhzo.soap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.abelhzo.soap.bo.services.UsersServiceBO;
import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.UserJAX;
import com.abelhzo.soap.service.UserService;

@WebService(serviceName = "UsersServiceSOAP", 
			portName = "UsersServicePortSOAP", 
			endpointInterface = "com.abelhzo.soap.service.UserService", 
			targetNamespace = "http://abelhzo.users/")
public class User extends SpringBeanAutowiringSupport implements UserService {

	@Autowired
	private UsersServiceBO usersServicesBO;

	@Override
	public ResponseWrapper<UserJAX.UserRS> saveUser(ConfigJAX config, UserJAX.UserAddRQ rq) {
		return usersServicesBO.saveUser(config, rq);
	}

	@Override
	public ResponseWrapper<UserJAX.UserRS> updateUser(ConfigJAX config, UserJAX.UserUpdateRQ rq) {
		return usersServicesBO.updateUser(config, rq);
	}

	@Override
	public ResponseWrapper<UserJAX.UserRS> getUser(ConfigJAX config, Long iduser) {
		return usersServicesBO.getUser(config, iduser);
	}

	@Override
	public ResponseWrapper<UserJAX.UserRS> listUsers(ConfigJAX config) {
		return usersServicesBO.listUsers(config);
	}

	@Override
	public ResponseWrapper<UserJAX.UserRS> loginUser(ConfigJAX config, UserJAX.UserLoginRQ rq) {
		return usersServicesBO.loginUser(config, rq);
	}

	@Override
	public ResponseWrapper<UserJAX.UserRS> logoutUser(ConfigJAX config, UserJAX.UserLogoutRQ rq) {
		return usersServicesBO.logoutUser(config, rq);
	}

}
