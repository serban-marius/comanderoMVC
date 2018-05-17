package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.NuevoEditarCategoriaV;
import model.NuevoEditarCategoriaM;

public class NuevoEditarCategoriaC {
	private NuevoEditarCategoriaV nuevaCate = null;
	private NuevoEditarCategoriaM nuevaCateM = null;
	private String nombreNuevaCat = "";
	private int id;
	
	public void nuevaCat() {
		nuevaCate = new NuevoEditarCategoriaV();
		nuevaCateM = new NuevoEditarCategoriaM();
		
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
				nuevaCateM.newCat(nombreNuevaCat);
				cerrarVista();
			}
		});
	}
	
	public void editCat(Integer idca, String nombreActual) {
		nuevaCate = new NuevoEditarCategoriaV();
		nuevaCateM = new NuevoEditarCategoriaM();
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
				id = idca;
				nuevaCateM.editCat(id, nombreNuevaCat);
				cerrarVista();
			}
		});
	}
	
	public void cerrarVista() {
		nuevaCate.dispose();
	}

}
