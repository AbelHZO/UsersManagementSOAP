package com.abelhzo.soap.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://abelhzo.commons/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageItemJAX {

	@XmlElement(required = true)
	private String status;
	@XmlElement(required = true)
	private List<MessageJAX> message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MessageJAX> getMessage() {
		if (message == null) {
			message = new ArrayList<MessageJAX>();
		}
		return message;
	}

	public void setMessage(List<MessageJAX> message) {
		this.message = message;
	}

}
