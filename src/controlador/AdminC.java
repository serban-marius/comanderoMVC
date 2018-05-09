package controlador;

import vista.AdminV;

public class AdminC {
	private static AdminV vista = null;
	
	public void generarAdmin(){
		vista = new AdminV();
	}
}
