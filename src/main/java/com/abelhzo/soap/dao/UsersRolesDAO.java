package com.abelhzo.soap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelhzo.jpa.Usersrole;
import com.abelhzo.soap.dao.services.UsersRolesServiceDAO;
import com.abelhzo.soap.repositorys.UsersRolesRepository;

@Service
public class UsersRolesDAO implements UsersRolesServiceDAO {

	@Autowired
	private UsersRolesRepository usersRolesRepository;

	@Override
	public Usersrole saveUserRole(Usersrole userrole) {
		return usersRolesRepository.save(userrole);
	}

	@Override
	@Transactional
	public Usersrole updateUserRole(Usersrole userrole) {
		return usersRolesRepository.saveAndFlush(userrole);
	}

	@Override
	public Usersrole getUserRole(Usersrole userrole) {
		return null;
	}

	@Override
	public List<Usersrole> findByIdUser(Long idUser) {
		return usersRolesRepository.findByIduser(idUser);
	}

	@Override
	@Transactional
	public void deleteUserRoleByIduser(Long iduser) {
		usersRolesRepository.deleteUsersRolesByIduser(iduser);
	}

}
