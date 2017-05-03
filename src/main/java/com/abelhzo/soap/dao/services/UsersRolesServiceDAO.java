package com.abelhzo.soap.dao.services;

import java.util.List;

import com.abelhzo.jpa.Usersrole;

public interface UsersRolesServiceDAO {
	
	public Usersrole saveUserRole(Usersrole userrole);
	public Usersrole updateUserRole(Usersrole userrole);
	public Usersrole getUserRole(Usersrole userrole);
	public List<Usersrole> findByIdUser(Long idUser);
	public void deleteUserRoleByIduser(Long iduser);

}
