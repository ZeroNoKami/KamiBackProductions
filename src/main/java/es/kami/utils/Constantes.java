package es.kami.utils;


public class Constantes {
	//Tipos de usuario
	public static final String ADMIN 						= "ADMIN";
	public static final String REGISTERED 					= "REGISTERED";
	public static final String UNREGISTERED 				= "UNREGISTERED";
	
	//Añadir rol de seguridad
		//Grupos de usuarios
		public static final String USER_ALLOW_ALL          = "hasAnyRole('ADMIN', 'REGISTERED', 'UNREGISTERED)";
		public static final String USER_ALLOW_ALL_REG      = "hasAnyRole('ADMIN', 'REGISTERED')";
		
		//Usuarios solo
		public static final String USER_ALLOW_ADMIN         = "hasAuthority('ADMIN')";
		public static final String USER_ALLOW_UNREGISTERED 	= "hasAuthority('UNREGISTERED')";
		public static final String USER_ALLOW_REGISTERED   	= "hasAuthority('REGISTERED')";
}
