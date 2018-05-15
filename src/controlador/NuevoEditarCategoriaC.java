package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.NuevoEditarCategoriaV;
import model.NuevoEditarCategoriaM;

public class NuevoEditarCategoriaC {
	private static NuevoEditarCategoriaV nuevaCate = null;
	private static String nombreNuevaCat = "";
	
	public static void nuevaCat() {
		nuevaCate = new NuevoEditarCategoriaV();
		
		//Eventos de la ventana
		// ---- BOTON VOLVER ----------
		nuevaCate.btnBacktoCat().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		// ----- BOTON GUARDAR CATEGORÍA
		nuevaCate.btnSaveNewCategory().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombreNuevaCat = nuevaCate.textNewCat().getText();
				NuevoEditarCategoriaM.newCat(nombreNuevaCat);
			}
		});
	}
	
	public static void editCat(Integer id, String nombreActual) {
		nuevaCate = new NuevoEditarCategoriaV();
		
		nuevaCate.textNewCat().setText(nombreActual);
		
		//Eventos de la ventana
		// ---- BOTON VOLVER ----------
		nuevaCate.btnBacktoCat().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		// ----- BOTON EDITAR CATEGORÍA
		nuevaCate.btnSaveNewCategory().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombreNuevaCat = nuevaCate.textNewCat().getText();
				NuevoEditarCategoriaM.editCat(id, nombreNuevaCat);
			}
		});
	}
	
	public static void cerrarVista() {
		nuevaCate.dispose();
	}

}
