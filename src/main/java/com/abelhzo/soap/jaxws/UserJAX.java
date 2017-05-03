package com.abelhzo.soap.jaxws;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.abelhzo.soap.jaxws.UserRoleJAX.UserRolRS;
import com.abelhzo.soap.jaxws.UserRoleJAX.UserRoleAddRQ;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class UserJAX {

	@XmlElement(required = true)
	private String username;
	@XmlElement(required = true)
	private String email;
	@XmlElement(required = true)
	private String password;
	@XmlElement(required = true)
	private Date birthday;
	@XmlElement(required = false)
	private String name;
	@XmlElement(required = false)
	private String firstlastname;
	@XmlElement(required = false)
	private String secondlastname;
	@XmlElement(required = false)
	private String celphone;
	@XmlElement(required = false)
	private String address;
	@XmlElement(required = false)
	private String genre;
	@XmlElement(required = false)
	private BigDecimal active;
	@XmlElement(required = true, name = "UserRoleAddRQ")
	private List<UserRoleAddRQ> userrol;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstlastname() {
		return firstlastname;
	}

	public void setFirstlastname(String firstlastname) {
		this.firstlastname = firstlastname;
	}

	public String getSecondlastname() {
		return secondlastname;
	}

	public void setSecondlastname(String secondlastname) {
		this.secondlastname = secondlastname;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public BigDecimal getActive() {
		return active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
	}

	public List<UserRoleAddRQ> getUserrol() {
		return userrol;
	}

	public void setUserrol(List<UserRoleAddRQ> userrol) {
		this.userrol = userrol;
	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserAddRQ extends UserJAX {

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserUpdateRQ extends UserJAX {

		@XmlElement(required = true)
		private Long iduser;

		public Long getIduser() {
			return iduser;
		}

		public void setIduser(Long iduser) {
			this.iduser = iduser;
		}

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserLoginRQ {

		@XmlElement(required = true)
		private String username;
		@XmlElement(required = true)
		private String password;
		@XmlElement(required = true)
		private String ip;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserLogoutRQ {

		@XmlElement(required = true)
		private Long iduser;

		public Long getIduser() {
			return iduser;
		}

		public void setIduser(Long iduser) {
			this.iduser = iduser;
		}

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UserRS {

		@XmlElement(required = true)
		private Long iduser;
		@XmlElement(required = true)
		private String username;
		@XmlElement(required = true)
		private String email;
		@XmlElement(required = true)
		private String password;
		@XmlElement(required = true)
		private Date birthday;
		@XmlElement(required = true)
		private String name;
		@XmlElement(required = true)
		private String firstlastname;
		@XmlElement(required = true)
		private String secondlastname;
		@XmlElement(required = true)
		private String celphone;
		@XmlElement(required = true)
		private String address;
		@XmlElement(required = true)
		private String genre;
		@XmlElement(required = true)
		private BigDecimal active;
		@XmlElement(required = true)
		@XmlJavaTypeAdapter(TimestampAdapter.class)
		private Timestamp registerdate;
		@XmlElement(required = true)
		@XmlJavaTypeAdapter(TimestampAdapter.class)
		private Timestamp updatedate;
		@XmlElement(required = true)
		private BigDecimal updatecount;
		@XmlElement(required = true, name = "UserRolRS")
		private List<UserRolRS> userrol;

		public Long getIduser() {
			return iduser;
		}

		public void setIduser(Long iduser) {
			this.iduser = iduser;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFirstlastname() {
			return firstlastname;
		}

		public void setFirstlastname(String firstlastname) {
			this.firstlastname = firstlastname;
		}

		public String getSecondlastname() {
			return secondlastname;
		}

		public void setSecondlastname(String secondlastname) {
			this.secondlastname = secondlastname;
		}

		public String getCelphone() {
			return celphone;
		}

		public void setCelphone(String celphone) {
			this.celphone = celphone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public BigDecimal getActive() {
			return active;
		}

		public void setActive(BigDecimal active) {
			this.active = active;
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

		public BigDecimal getUpdatecount() {
			return updatecount;
		}

		public void setUpdatecount(BigDecimal updatecount) {
			this.updatecount = updatecount;
		}

		public List<UserRolRS> getUserrol() {
			return userrol;
		}

		public void setUserrol(List<UserRolRS> userrol) {
			this.userrol = userrol;
		}

	}

}
