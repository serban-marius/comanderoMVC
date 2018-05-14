package controlador;

import controlador.AdminC;
import controlador.CobroC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.InicioV;

public class InicioC {
	private static InicioV vista = null;
	private static AdminC admin = new AdminC();
	private static CobroC cobro = new CobroC();
	
	public static void generarInicio(){
		vista = new InicioV();
		// Eventos de la ventana
			vista.btnAdmin().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cerrarVista();
					admin.generarAdmin();
				}
			});
			vista.btnCobro().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cerrarVista();
					cobro.generarCobro();
				}
			});
	}
	
	public static void cerrarVista() {
		vista.dispose();
	}
}
