package com.abelhzo.soap.dao.services;

import java.util.List;

import com.abelhzo.jpa.Role;

public interface RolesServiceDAO {

	public Role saveRol(Role role);
	public Role updateRol(Role role);
	public Role getRol(Long idRole);
	public List<Role> listRol();

}
