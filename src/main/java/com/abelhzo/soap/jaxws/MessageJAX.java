package com.abelhzo.soap.jaxws;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"code", "type", "current", "criticality", "description"}, namespace = "http://abelhzo.commons/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageJAX {

	@XmlElement(required = true)
	protected String code;
	@XmlElement(required = true)
	protected String type;
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	protected Timestamp current;
	@XmlElement(required = true)
	protected String criticality;
	@XmlElement(required = true)
	protected String description;

	public MessageJAX(String code, String type, Timestamp current, String criticality, String description) {
		super();
		this.code = code;
		this.type = type;
		this.current = current;
		this.criticality = criticality;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getCurrent() {
		return current;
	}

	public void setCurrent(Timestamp current) {
		this.current = current;
	}

	public String getCriticality() {
		return criticality;
	}

	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
