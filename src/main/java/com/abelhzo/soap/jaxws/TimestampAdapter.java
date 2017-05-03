package com.abelhzo.soap.jaxws;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter extends XmlAdapter<String, Timestamp> {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Timestamp unmarshal(String v) throws Exception {
		return new Timestamp(dateFormat.parse(v).getTime());
	}

	@Override
	public String marshal(Timestamp v) throws Exception {
		return dateFormat.format(v);
	}

}
