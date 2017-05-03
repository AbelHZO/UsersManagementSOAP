package com.abelhzo.soap.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abelhzo.jpa.Accessuser;
import com.abelhzo.jpa.AccessuserPK;
import com.abelhzo.jpa.User;
import com.abelhzo.jpa.Usersrole;
import com.abelhzo.jpa.UsersrolePK;
import com.abelhzo.soap.annotations.Validateconfig;
import com.abelhzo.soap.bo.services.UsersServiceBO;
import com.abelhzo.soap.dao.services.AccessUsersServiceDAO;
import com.abelhzo.soap.dao.services.RolesServiceDAO;
import com.abelhzo.soap.dao.services.UsersRolesServiceDAO;
import com.abelhzo.soap.dao.services.UsersServiceDAO;
import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.UserJAX;
import com.abelhzo.soap.jaxws.UserRoleJAX.UserRolRS;
import com.abelhzo.soap.jaxws.UserRoleJAX.UserRoleAddRQ;
import com.abelhzo.soap.messages.Codes;
import com.abelhzo.soap.messages.MessagesFactory;

@Service
public class UsersBO implements UsersServiceBO {

	@Autowired
	private UsersServiceDAO usersServiceDAO;

	@Autowired
	private UsersRolesServiceDAO usersRolesServiceDAO;

	@Autowired
	private RolesServiceDAO rolesServiceDAO;

	@Autowired
	private AccessUsersServiceDAO accessUsersServiceDAO;

	@Autowired
	private MessagesFactory messagesFactory;

	@Override
	@Validateconfig
	public ResponseWrapper<UserJAX.UserRS> saveUser(ConfigJAX config, UserJAX.UserAddRQ rq) {

		ResponseWrapper<UserJAX.UserRS> data = new ResponseWrapper<UserJAX.UserRS>();

		Long id = new Date().getTime();

		User user = new User();

		try {

			user.setIduser(id);
			user.setUsername(rq.getUsername());
			user.setEmail(rq.getEmail());
			user.setPassword(rq.getPassword());
			user.setBirthday(rq.getBirthday());
			user.setName(rq.getName());
			user.setFirstlastname(rq.getFirstlastname());
			user.setSecondlastname(rq.getSecondlastname());
			user.setCelphone(rq.getCelphone());
			user.setAddress(rq.getAddress());
			user.setGenre(rq.getGenre());
			user.setActive(rq.getActive());
			user.setRegisterdate(new Timestamp(new Date().getTime()));
			user.setUpdatecount(BigDecimal.valueOf(0));

		} catch (Exception e) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorParams("ERROR EN LOS PARAMETROS: " + e.getMessage()));
			data.setResult(new UserJAX.UserRS());

			return data;

		}

		user = usersServiceDAO.saveUser(user);

		if (user == null) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorInsert("ERROR AL GUARDAR"));
			data.setResult(new UserJAX.UserRS());

			return data;
		}

		List<UserRolRS> listUsersRoles = new ArrayList<UserRolRS>();
		for (UserRoleAddRQ r : rq.getUserrol()) {

			UsersrolePK usersrolepk = new UsersrolePK();
			usersrolepk.setIdrol(r.getIdrol());
			usersrolepk.setIduser(id);

			Usersrole userrole = new Usersrole();
			userrole.setId(usersrolepk);

			userrole = usersRolesServiceDAO.saveUserRole(userrole);

			UserRolRS userrol = new UserRolRS();
			userrol.setIdrol(userrole.getId().getIdrol());
			userrol.setRol(rolesServiceDAO.getRol(userrole.getId().getIdrol()).getRol());

			listUsersRoles.add(userrol);
		}

		UserJAX.UserRS userjax = new UserJAX.UserRS();
		userjax.setIduser(user.getIduser());
		userjax.setUsername(user.getUsername());
		userjax.setEmail(user.getEmail());
		userjax.setPassword(user.getPassword());
		userjax.setBirthday(user.getBirthday());
		userjax.setName(user.getName());
		userjax.setFirstlastname(user.getFirstlastname());
		userjax.setSecondlastname(user.getSecondlastname());
		userjax.setCelphone(user.getCelphone());
		userjax.setAddress(user.getAddress());
		userjax.setGenre(user.getGenre());
		userjax.setActive(user.getActive());
		userjax.setRegisterdate(user.getRegisterdate());
		userjax.setUserrol(listUsersRoles);

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("EXITOSAMENTE GUARDAR"));
		data.setResult(userjax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<UserJAX.UserRS> updateUser(ConfigJAX config, UserJAX.UserUpdateRQ rq) {

		ResponseWrapper<UserJAX.UserRS> data = new ResponseWrapper<UserJAX.UserRS>();

		User user = new User();

		try {

			user.setIduser(rq.getIduser());
			user.setUsername(rq.getUsername());
			user.setEmail(rq.getEmail());
			user.setPassword(rq.getPassword());
			user.setBirthday(rq.getBirthday());
			user.setName(rq.getName());
			user.setFirstlastname(rq.getFirstlastname());
			user.setSecondlastname(rq.getSecondlastname());
			user.setCelphone(rq.getCelphone());
			user.setAddress(rq.getAddress());
			user.setGenre(rq.getGenre());
			user.setActive(rq.getActive());
			user.setUpdatedate(new Timestamp(new Date().getTime()));

		} catch (Exception e) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorParams("ERROR EN LOS PARAMETROS: " + e.getMessage()));
			data.setResult(new UserJAX.UserRS());

			return data;

		}

		user = usersServiceDAO.updateUser(user);

		if (user == null) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorUpdate("ERROR AL ACTUALIZAR"));
			data.setResult(new UserJAX.UserRS());

			return data;
		}

		usersRolesServiceDAO.deleteUserRoleByIduser(user.getIduser());

		List<UserRolRS> listUsersRoles = new ArrayList<UserRolRS>();
		for (UserRoleAddRQ r : rq.getUserrol()) {

			UsersrolePK usersrolepk = new UsersrolePK();
			usersrolepk.setIdrol(r.getIdrol());
			usersrolepk.setIduser(rq.getIduser());

			Usersrole userrole = new Usersrole();
			userrole.setId(usersrolepk);

			userrole = usersRolesServiceDAO.updateUserRole(userrole);

			UserRolRS userrol = new UserRolRS();
			userrol.setIdrol(userrole.getId().getIdrol());
			userrol.setRol(rolesServiceDAO.getRol(userrole.getId().getIdrol()).getRol());

			listUsersRoles.add(userrol);
		}

		UserJAX.UserRS userjax = new UserJAX.UserRS();
		userjax.setIduser(user.getIduser());
		userjax.setUsername(user.getUsername());
		userjax.setEmail(user.getEmail());
		userjax.setPassword(user.getPassword());
		userjax.setBirthday(user.getBirthday());
		userjax.setName(user.getName());
		userjax.setFirstlastname(user.getFirstlastname());
		userjax.setSecondlastname(user.getSecondlastname());
		userjax.setCelphone(user.getCelphone());
		userjax.setAddress(user.getAddress());
		userjax.setGenre(user.getGenre());
		userjax.setActive(user.getActive());
		userjax.setUpdatedate(user.getUpdatedate());
		userjax.setUpdatecount(user.getUpdatecount());
		userjax.setUserrol(listUsersRoles);

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("EXITOSAMENTE ACTUALIZADO"));
		data.setResult(userjax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<UserJAX.UserRS> getUser(ConfigJAX config, Long idUser) {

		ResponseWrapper<UserJAX.UserRS> data = new ResponseWrapper<UserJAX.UserRS>();

		User user = new User();
		user.setIduser(idUser);

		user = usersServiceDAO.getUser(user);

		if (user == null) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.userIncorrect("ERROR DE USUARIO"));
			data.setResult(new UserJAX.UserRS());

			return data;
		}

		List<Usersrole> userrole = usersRolesServiceDAO.findByIdUser(user.getIduser());
		List<UserRolRS> listuserlorejax = new ArrayList<UserRolRS>();

		for (Usersrole ur : userrole) {
			UserRolRS userrol = new UserRolRS();
			userrol.setIdrol(ur.getId().getIdrol());
			userrol.setRol(rolesServiceDAO.getRol(ur.getId().getIdrol()).getRol());
			listuserlorejax.add(userrol);
		}

		UserJAX.UserRS userjax = new UserJAX.UserRS();
		userjax.setIduser(user.getIduser());
		userjax.setUsername(user.getUsername());
		userjax.setEmail(user.getEmail());
		userjax.setPassword(user.getPassword());
		userjax.setBirthday(user.getBirthday());
		userjax.setName(user.getName());
		userjax.setFirstlastname(user.getFirstlastname());
		userjax.setSecondlastname(user.getSecondlastname());
		userjax.setCelphone(user.getCelphone());
		userjax.setAddress(user.getAddress());
		userjax.setGenre(user.getGenre());
		userjax.setActive(user.getActive());
		userjax.setRegisterdate(user.getRegisterdate());
		userjax.setUpdatedate(user.getUpdatedate());
		userjax.setUpdatecount(user.getUpdatecount());
		userjax.setUserrol(listuserlorejax);

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("USUARIO OBTENIDO"));
		data.setResult(userjax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<UserJAX.UserRS> listUsers(ConfigJAX config) {

		ResponseWrapper<UserJAX.UserRS> data = new ResponseWrapper<UserJAX.UserRS>();

		List<User> listaUsuarios = usersServiceDAO.listUsers();
		List<UserJAX.UserRS> listUserJax = new ArrayList<UserJAX.UserRS>();

		if (listaUsuarios.size() == 0) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.notFoundResult("NO SE ENCONTRARON RESULTADOS"));
			data.setResultslist(listUserJax);

			return data;
		}

		for (User user : listaUsuarios) {

			List<Usersrole> userrole = usersRolesServiceDAO.findByIdUser(user.getIduser());
			List<UserRolRS> listuserlorejax = new ArrayList<UserRolRS>();

			for (Usersrole ur : userrole) {
				UserRolRS userrol = new UserRolRS();
				userrol.setIdrol(ur.getId().getIdrol());
				userrol.setRol(rolesServiceDAO.getRol(ur.getId().getIdrol()).getRol());
				listuserlorejax.add(userrol);
			}

			UserJAX.UserRS userjax = new UserJAX.UserRS();
			userjax.setIduser(user.getIduser());
			userjax.setUsername(user.getUsername());
			userjax.setEmail(user.getEmail());
			userjax.setPassword(user.getPassword());
			userjax.setBirthday(user.getBirthday());
			userjax.setName(user.getName());
			userjax.setFirstlastname(user.getFirstlastname());
			userjax.setSecondlastname(user.getSecondlastname());
			userjax.setCelphone(user.getCelphone());
			userjax.setAddress(user.getAddress());
			userjax.setGenre(user.getGenre());
			userjax.setActive(user.getActive());
			userjax.setRegisterdate(user.getRegisterdate());
			userjax.setUpdatedate(user.getUpdatedate());
			userjax.setUpdatecount(user.getUpdatecount());
			userjax.setUserrol(listuserlorejax);

			listUserJax.add(userjax);

		}

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("RESULTADOS LISTADOS"));
		data.setResultslist(listUserJax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<UserJAX.UserRS> loginUser(ConfigJAX config, UserJAX.UserLoginRQ rq) {

		ResponseWrapper<UserJAX.UserRS> data = new ResponseWrapper<UserJAX.UserRS>();

		User user = new User();

		try {

			user.setUsername(rq.getUsername());
			user.setPassword(rq.getPassword());

		} catch (Exception e) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorParams("ERROR EN LOS PARAMETROS: " + e.getMessage()));
			data.setResult(new UserJAX.UserRS());

			return data;
		}

		user = usersServiceDAO.loginUser(user);

		if (user != null) {

			AccessuserPK accesspk = new AccessuserPK();
			accesspk.setDateaccess(new Timestamp(new Date().getTime()));
			accesspk.setIduser(user.getIduser());

			Accessuser access = new Accessuser();
			access.setId(accesspk);
			access.setIp(rq.getIp());
			access.setSessionactive(BigDecimal.valueOf(1));

			Accessuser accessactive = accessUsersServiceDAO.isActiveSessionUser(access);

			if (accessactive == null) {

				access = accessUsersServiceDAO.saveAccessUsers(access);

				UserJAX.UserRS userjax = new UserJAX.UserRS();
				userjax.setIduser(user.getIduser());
				userjax.setUsername(user.getUsername());
				userjax.setEmail(user.getEmail());
				userjax.setBirthday(user.getBirthday());
				userjax.setName(user.getName());
				userjax.setFirstlastname(user.getFirstlastname());
				userjax.setSecondlastname(user.getSecondlastname());
				userjax.setCelphone(user.getCelphone());
				userjax.setAddress(user.getAddress());
				userjax.setGenre(user.getGenre());
				userjax.setActive(user.getActive());
				userjax.setRegisterdate(user.getRegisterdate());
				userjax.setUpdatedate(user.getUpdatedate());
				userjax.setUpdatecount(user.getUpdatecount());

				data.setStatus(Codes.OK);
				data.getMessage().add(messagesFactory.successResult("ACCESO EXITOSO"));
				data.setResult(userjax);

				return data;
			}

			data.setStatus(Codes.OK);
			data.getMessage().add(messagesFactory.sessionActive("YA HAY UNA SESION ACTIVA"));
			data.setResult(new UserJAX.UserRS());

			return data;

		} else {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.loginError("ERROR DE USUARIO O PASSWORD"));
			data.setResult(new UserJAX.UserRS());

			return data;
		}

	}

	@Override
	@Validateconfig
	public ResponseWrapper<UserJAX.UserRS> logoutUser(ConfigJAX config, UserJAX.UserLogoutRQ rq) {
		AccessuserPK accesspk = new AccessuserPK();
		accesspk.setIduser(rq.getIduser());

		Accessuser access = new Accessuser();
		access.setId(accesspk);
		access.setSessionactive(BigDecimal.valueOf(0));

		Integer rows = accessUsersServiceDAO.logoutAccessUsers(access);

		if (rows != 0) {
			ResponseWrapper<UserJAX.UserRS> data = getUser(config, rq.getIduser());
			return data;
		} else {
			return new ResponseWrapper<UserJAX.UserRS>();
		}

	}

}
