package controlador;

import controlador.AdminC;
import controlador.CobroC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.InicioV;

public class InicioC {
	private static InicioV vista = null;
	public static void main(String[] args) {
		generarVentana();
	}
	
	public InicioC() {
		generarVentana();
	}
	
	public static void generarVentana() {
		vista = new InicioV();
		
		vista.btnAdmin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminC().generarAdmin();;
			}
		});
		
		
		vista.btnCobro().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
				new CobroC().generarCobro();;
			}
		});
		
	}
	public static void cerrarVista() {
		vista.dispose();
	}
	
	
}

