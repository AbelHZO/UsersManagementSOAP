package com.abelhzo.soap.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelhzo.jpa.Accessuser;
import com.abelhzo.soap.dao.services.AccessUsersServiceDAO;
import com.abelhzo.soap.repositorys.AccessUsersRepository;

@Service
public class AccessUsersDAO implements AccessUsersServiceDAO {
	
	@Autowired
	private AccessUsersRepository accessUsersRepository;

	@Override
	@Transactional
	public Accessuser saveAccessUsers(Accessuser accessuser) {
		return accessUsersRepository.save(accessuser);
	}

	@Override
	@Transactional
	public Integer logoutAccessUsers(Accessuser accessuser) {
		return accessUsersRepository.logoutAccessUsers(accessuser.getSessionactive(), 
													   accessuser.getId().getIduser());
	}

	@Override
	public Accessuser isActiveSessionUser(Accessuser accessuser) {
		return accessUsersRepository.isActiveSessionUser(accessuser.getId().getIduser());
	}

	@Override
	@Transactional
	public void deleteLastAccess(Accessuser accessuser) {
		accessUsersRepository.deleteLastAccess(accessuser.getId().getIduser(), 
											   accessuser.getId().getDateaccess());
	}
	
}
