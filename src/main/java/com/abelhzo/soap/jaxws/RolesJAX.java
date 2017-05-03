package com.abelhzo.soap.jaxws;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class RolesJAX {
	@XmlElement(required = true)
	private String rol;

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class RolesAddRQ extends RolesJAX {

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class RolesUpdateRQ extends RolesJAX {

		@XmlElement(required = true)
		private Long idrol;

		public Long getIdrol() {
			return idrol;
		}

		public void setIdrol(Long idrol) {
			this.idrol = idrol;
		}

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class RolRS {

		@XmlElement(required = true)
		private Long idrol;
		@XmlElement(required = true)
		private String rol;
		@XmlElement(required = true)
		@XmlJavaTypeAdapter(TimestampAdapter.class)
		private Timestamp registerdate;
		@XmlElement(required = true)
		@XmlJavaTypeAdapter(TimestampAdapter.class)
		private Timestamp updatedate;

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

		public Timestamp getRegisterdate() {
			return registerdate;
		}

		public void setRegisterdate(Timestamp registerdate) {
			this.registerdate = registerdate;
		}

		public Timestamp getUpdatedate() {
			return updatedate;
		}

		public void setUpdatedate(Timestamp updatedate) {
			this.updatedate = updatedate;
		}

	}

}
