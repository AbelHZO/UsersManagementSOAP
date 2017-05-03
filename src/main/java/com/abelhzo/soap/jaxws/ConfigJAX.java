package com.abelhzo.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.abelhzo.soap.enums.Language;

@XmlType(namespace = "http://abelhzo.commons/")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigJAX {

	@XmlElement(required = true)
	private Long iduser;
	@XmlElement(required = true)
	private String ip;
	@XmlElement(required = true)
	private Language language;

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
