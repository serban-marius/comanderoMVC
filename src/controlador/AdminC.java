package controlador;

import vista.AdminV;

public class AdminC {
	private static AdminV vista = null;
	
	public static void generarAdmin(){
		vista = new AdminV();
		// Eventos de la ventana
	}
}
