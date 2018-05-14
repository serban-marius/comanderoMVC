package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AdminV;

public class AdminC {
	private static AdminV vista = null;
	
	public static void generarAdmin(){
		vista = new AdminV();
		// Eventos de la ventana
		vista.btnAddMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
				
			}
		});
	}
	
	private static void cerrarVista() {
		vista.dispose();
	}
}
