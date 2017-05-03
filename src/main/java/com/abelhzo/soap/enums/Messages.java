package com.abelhzo.soap.enums;

public enum Messages {
	SUCCESS("001", "SUCCESS", "PROCESADO EXITOSAMENTE"), 
	EMPTY("002", "SUCCESS", "SIN DATOS POR MOSTRAR"), 
	ACTIVESESION("003", "SUCCESS", "HAY UNA SESION ACTIVA"), 
	LOGINERROR("004", "SUCCESS", "USUARIO O PASSWORD INCORRECTOS"),  
   	IDERROR("005", "SUCCESS", "ID NO ENCONTRADO"), 
   	ERROR("006", "SUCCESS", "ERROR AL REALIZAR LA OPERACIÓN");

	private final String code;
	private final String type;
	private final String message;

	private Messages(String code, String type, String message) {
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

}
