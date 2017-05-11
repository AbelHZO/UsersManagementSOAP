package com.abelhzo.soap.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abelhzo.jpa.Role;
import com.abelhzo.soap.annotations.Validateconfig;
import com.abelhzo.soap.bo.services.RolesServiceBO;
import com.abelhzo.soap.dao.services.RolesServiceDAO;
import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.RolesJAX;
import com.abelhzo.soap.messages.Codes;
import com.abelhzo.soap.messages.MessagesFactory;

@Service
public class RolesBO implements RolesServiceBO {

	@Autowired
	private RolesServiceDAO rolesServiceDAO;

	@Autowired
	private MessagesFactory messagesFactory;

	@Override
	@Validateconfig
	public ResponseWrapper<RolesJAX.RolRS> saveRol(ConfigJAX config, RolesJAX.RolesAddRQ rq) {

		ResponseWrapper<RolesJAX.RolRS> data = new ResponseWrapper<RolesJAX.RolRS>();

		Role role = new Role();
		role.setIdrol(new Date().getTime());
		role.setRegisterdate(new Timestamp(new Date().getTime()));
		role.setRol(rq.getRol());

		role = rolesServiceDAO.saveRol(role);


		if (role == null) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorInsert("ERROR AL INSERTAR"));

			return data;
		}

		RolesJAX.RolRS rolejax = new RolesJAX.RolRS();
		rolejax.setIdrol(role.getIdrol());
		rolejax.setRol(role.getRol());
		rolejax.setRegisterdate(role.getRegisterdate());

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("EXITOSAMENTE GUARDADO"));
		data.setResult(rolejax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<RolesJAX.RolRS> updateRol(ConfigJAX config, RolesJAX.RolesUpdateRQ rq) {

		ResponseWrapper<RolesJAX.RolRS> data = new ResponseWrapper<RolesJAX.RolRS>();

		Role role = new Role();
		role.setIdrol(rq.getIdrol());
		role.setUpdatedate(new Timestamp(new Date().getTime()));
		role.setRol(rq.getRol());

		role = rolesServiceDAO.updateRol(role);


		if (role == null) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.errorUpdate("ERROR AL ACTUALIZAR"));

			return data;
		}

		RolesJAX.RolRS rolejax = new RolesJAX.RolRS();
		rolejax.setIdrol(role.getIdrol());
		rolejax.setRol(role.getRol());
		rolejax.setUpdatedate(role.getUpdatedate());

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("EXITOSAMENTE ACTUALIZADO"));
		data.setResult(rolejax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<RolesJAX.RolRS> getRol(ConfigJAX config, Long idrol) {

		ResponseWrapper<RolesJAX.RolRS> data = new ResponseWrapper<RolesJAX.RolRS>();

		Role role = rolesServiceDAO.getRol(idrol);

		if (role == null) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.userIncorrect("USUARIO INCORRECTO"));
			data.setResult(new RolesJAX.RolRS());

			return data;
		}

		RolesJAX.RolRS rolejax = new RolesJAX.RolRS();

		rolejax.setIdrol(role.getIdrol());
		rolejax.setRol(role.getRol());
		rolejax.setRegisterdate(role.getRegisterdate());
		rolejax.setUpdatedate(role.getUpdatedate());

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("USUARIO ENCONTRADO"));
		data.setResult(rolejax);

		return data;
	}

	@Override
	@Validateconfig
	public ResponseWrapper<RolesJAX.RolRS> listRol(ConfigJAX config) {

		ResponseWrapper<RolesJAX.RolRS> data = new ResponseWrapper<RolesJAX.RolRS>();

		List<Role> listRoles = rolesServiceDAO.listRol();
		List<RolesJAX.RolRS> listRolesJax = new ArrayList<RolesJAX.RolRS>();

		if (listRoles.size() == 0) {

			data.setStatus(Codes.KO);
			data.getMessage().add(messagesFactory.notFoundResult("NO SE ENCONTRARON RESULTADOS"));
			data.setResultslist(listRolesJax);

			return data;
		}

		for (Role role : listRoles) {
			RolesJAX.RolRS rolejax = new RolesJAX.RolRS();
			rolejax.setIdrol(role.getIdrol());
			rolejax.setRol(role.getRol());
			rolejax.setRegisterdate(role.getRegisterdate());
			rolejax.setUpdatedate(role.getUpdatedate());
			listRolesJax.add(rolejax);
		}

		data.setStatus(Codes.OK);
		data.getMessage().add(messagesFactory.successResult("RESULTADOS ENCONTRADOS"));
		data.setResultslist(listRolesJax);

		return data;
	}

}
