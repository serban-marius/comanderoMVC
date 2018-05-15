package controlador;

import controlador.AdminC;
import controlador.CobroC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.NuevoEditarProductoC;
import vista.InicioV;

public class InicioC {
	private static InicioV vista = null;
	
	public static void main(String[] args) {
		generarInicio();
	}
	
	public static void generarInicio(){
		vista = new InicioV();
		// Eventos de la ventana
			vista.btnAdmin().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AdminC.generarAdmin();
				}
			});
			vista.btnCobro().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cerrarVista();
					CobroC.generarCobro();
				}
			});
	}
	
	public static void cerrarVista() {
		vista.dispose();
	}
}
