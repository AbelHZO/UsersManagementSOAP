package com.abelhzo.soap.dao.services;

import com.abelhzo.jpa.Accessuser;

public interface AccessUsersServiceDAO {

	public Accessuser saveAccessUsers(Accessuser accessuser);

	public Integer logoutAccessUsers(Accessuser accessuser);

	public Accessuser isActiveSessionUser(Accessuser accessuser);

	public void deleteLastAccess(Accessuser accessuser);

}
