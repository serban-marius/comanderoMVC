package controlador;

import vista.InicioV;

public class InicioC {
	private static InicioV vista = null;
	
	public static void generarInicio(){
		vista = new InicioV();
	}
	
}
