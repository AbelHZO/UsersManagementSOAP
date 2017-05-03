package com.abelhzo.soap.bo.services;

import com.abelhzo.soap.jaxws.ConfigJAX;
import com.abelhzo.soap.jaxws.ResponseWrapper;
import com.abelhzo.soap.jaxws.RolesJAX;

public interface RolesServiceBO {

	public ResponseWrapper<RolesJAX.RolRS> saveRol(ConfigJAX config, RolesJAX.RolesAddRQ rq);
	public ResponseWrapper<RolesJAX.RolRS> updateRol(ConfigJAX config, RolesJAX.RolesUpdateRQ rq);
	public ResponseWrapper<RolesJAX.RolRS> getRol(ConfigJAX config, Long idRol);
	public ResponseWrapper<RolesJAX.RolRS> listRol(ConfigJAX config);

}
