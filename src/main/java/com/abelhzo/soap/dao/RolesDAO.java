package com.abelhzo.soap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelhzo.jpa.Role;
import com.abelhzo.soap.dao.services.RolesServiceDAO;
import com.abelhzo.soap.repositorys.RolesRepository;

@Service
public class RolesDAO implements RolesServiceDAO {
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Role saveRol(Role role) {
		return rolesRepository.save(role);
	}

	@Override
	@Transactional
	public Role updateRol(Role role) {
		
		Integer rows = rolesRepository.updateRoleCustomized(role.getRol(), 
															role.getUpdatedate(), 
															role.getIdrol());
		
		if(rows != 0) {
			return getRol(role.getIdrol());
		} else {
			return null;
		}
		 
	}

	@Override
	public Role getRol(Long idrole) {
		return rolesRepository.findOne(idrole);
	}

	@Override
	public List<Role> listRol() {
		return rolesRepository.findAll();
	}

}
