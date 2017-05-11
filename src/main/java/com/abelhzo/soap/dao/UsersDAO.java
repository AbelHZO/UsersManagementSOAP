package com.abelhzo.soap.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelhzo.jpa.User;
import com.abelhzo.soap.dao.services.UsersServiceDAO;
import com.abelhzo.soap.repositorys.UsersRepository;

@Service
public class UsersDAO implements UsersServiceDAO {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	@Transactional
	public User saveUser(User user) {
		return usersRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		User userCount = usersRepository.findOne(user.getIduser());

		if (userCount == null)
			return new User();

		if (userCount.getUpdatecount().intValueExact() < 3) {
			user.setUpdatecount(BigDecimal.valueOf(userCount.getUpdatecount().intValueExact() + 1));

			usersRepository.updateUserCustomized(user.getUsername(), user.getEmail(), user.getPassword(),
					user.getBirthday(), user.getName(), user.getFirstlastname(), user.getSecondlastname(),
					user.getCelphone(), user.getAddress(), user.getGenre(), user.getActive(),
					new Timestamp(new Date().getTime()), user.getUpdatecount(), user.getIduser());

			return usersRepository.findOne(Long.valueOf(user.getIduser()));
		} else {
			return null;
		}

	}

	@Override
	public User getUser(User user) {
		return usersRepository.findOne(user.getIduser());
	}

	@Override
	public List<User> listUsers() {
		return usersRepository.findAll();
	}

	@Override
	@Transactional
	public User loginUser(User user) {
		return usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

}

/**
 * Para que los Metodos findOne y getOne de Spring data Hibernate funcionen, lo
 * recomendable es que los id´s en los JPA sean Long y por lo tanto también en
 * la base detos sea Long, en Oracle 11g seria NUMBER(14)
 */
