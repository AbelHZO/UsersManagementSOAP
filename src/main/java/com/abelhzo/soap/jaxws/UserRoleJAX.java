package com.abelhzo.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRoleJAX {

	@XmlElement(required = true)
	private Long idrol;

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserRoleAddRQ extends UserRoleJAX {

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserRolRS {

		@XmlElement(required = true)
		private Long idrol;
		@XmlElement(required = true)
		private String rol;

		public Long getIdrol() {
			return idrol;
		}

		public void setIdrol(Long idrol) {
			this.idrol = idrol;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

	}

}
