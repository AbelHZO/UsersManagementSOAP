package com.abelhzo.soap.messages;

public class Codes {

	private Codes() {
	}

	/**
	 * Status valido
	 */
	public static final String OK = "OK";

	/**
	 * Status invalido
	 */
	public static final String KO = "KO";

	/**
	 * Criticidad de la aplicación:
	 * 
	 * -Criticidad Informativa: Cuando no ocurre ningun error y solo se desea
	 * notificar el exito. -Criticidad Error: Que pudiera ser de negocio pero
	 * controlado. (Ocurre un error). -Criticidad Fatal: Critico para la
	 * aplicación, error tecnico imposible de operar. -Criticidad Warning: Se
	 * debe de considerar la respuesta dado que se realizo la operación pero se
	 * tendra que considerar y evitarlo en el futuro.
	 */
	public static final String CRITICALITY_INFO = "INFO";
	public static final String CRITICALITY_ERROR = "ERROR";
	public static final String CRITICALITY_FATAL = "FATAL";
	public static final String CRITICALITY_WARN = "WARN";

	/**
	 * Tipos de error: - Negocio: Se pueden mostrar al usuario - Tecnico: Se
	 * enmascara el error de cara al usuario.
	 */
	public static final String BUSSINES = "N";
	public static final String TECNICAL = "T";

	/**
	 * Codigo de Exito
	 */
	public static final String SUCCESS = "SUCCESS";
	/**
	 * Codigo sin resultados
	 */
	public static final String EMPTY = "EMPTY";
	/**
	 * Error de login
	 */
	public static final String ERRORLOGIN = "ERROR_LOGIN";
	/**
	 * Error generico de usuario
	 */
	public static final String ERRORUSER = "ERROR_USER";
	/**
	 * El usuario tiene la sesion activa
	 */
	public static final String SESSIONACTIVE = "SESSION_ACTIVE";
	/**
	 * Error de parametros
	 */
	public static final String ERRORPARAMS = "ERROR_PARAMS";
	/**
	 * Exception presentada
	 */
	public static final String EXCEPTION = "EXCEPTION";
	/**
	 * Error generica de operación
	 */
	public static final String OPERATION = "OPERATION";

}
