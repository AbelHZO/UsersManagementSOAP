package com.abelhzo.soap.enums;

import java.util.Locale;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://abelhzo.commons/")
@XmlEnum
public enum Language {
	@XmlEnumValue("SPA")
	SPA("SPA"), 
	@XmlEnumValue("ENG")
	ENG("ENG");

	private String value;

	private Language(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public Locale getLocale() {
		Locale locale = null;

		if (value.equals("SPA")) {
			locale = new Locale("es");
		} else if (value.equals("ENG")) {
			locale = new Locale("en");
		}

		return locale;
	}

	public static Language fromValue(String v) {
		for (Language c : Language.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
