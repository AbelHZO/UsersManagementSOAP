package com.abelhzo.soap.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://abelhzo.commons/")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseWrapper<T> extends MessageItemJAX {

	@XmlElement(required = false)
	private T result;
	@XmlElement(required = false)
	private List<T> resultslist;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public List<T> getResultslist() {
		if (resultslist == null) {
			resultslist = new ArrayList<T>();
		}
		return resultslist;
	}

	public void setResultslist(List<T> resultslist) {
		this.resultslist = resultslist;
	}

}
