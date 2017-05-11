package com.abelhzo.soap.bo.services;

import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.UserJAX;

public interface UsersServiceBO {

	public ResponseWrapper<UserJAX.UserRS> saveUser(ConfigJAX config, UserJAX.UserAddRQ rq);

	public ResponseWrapper<UserJAX.UserRS> updateUser(ConfigJAX config, UserJAX.UserUpdateRQ rq);

	public ResponseWrapper<UserJAX.UserRS> getUser(ConfigJAX config, Long iduser);

	public ResponseWrapper<UserJAX.UserRS> listUsers(ConfigJAX config);

	public ResponseWrapper<UserJAX.UserRS> loginUser(ConfigJAX config, UserJAX.UserLoginRQ rq);

	public ResponseWrapper<UserJAX.UserRS> logoutUser(ConfigJAX config, UserJAX.UserLogoutRQ rq);

}
