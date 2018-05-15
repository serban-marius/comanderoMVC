package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AdminV;
import controlador.NuevoEditarProductoC;
import controlador.NuevoEditarCategoriaC;
import model.NuevoEditarCategoriaM;

public class AdminC {
	private static AdminV vista = null;
	
	public static void generarAdmin(){
		vista = new AdminV();
		// Eventos de la ventana
		// ----------------------- BOTONES VOLVER --------------------------
		vista.btnBack().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		vista.btnBackCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		vista.backButtonMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		// -----------------------------------------------------------------
		
		// ------------------------- BOTONES MESAS -------------------------
		//Botón Añadir Mesa
		vista.btnAddMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodo del modelo para añadir mesa
			}
		});
		//Botón Eliminar Mesa
		vista.btnDelMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodo del modelo para eliminar mesa
			}
		});
		// ---------------------------------------------------------------
		
		// ---------------------- BOTONES CATEGORIAS ---------------------
		//Botón Modificar Categoría
		vista.btnAddSaveCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.editCat(NuevoEditarCategoriaM.numeroCat(), NuevoEditarCategoriaM.nombreCat());
			}
		});
		//Botón Eliminar Categoría 
		vista.btnDelCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaM.delCat(NuevoEditarCategoriaM.numeroCat());
			}
		});
		//Botón Nueva Categoría -- BORRA SELECCIÓN TABLA --
		vista.btnNewCategory().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.nuevaCat();
			}
		});
		//---------------------------------------------------------------
		
		// --------------------- BOTONES PRODUCTOS ----------------------
		// Boton Añadir/Modificar Producto 
		vista.btnSaveEditProd().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//Boton Eliminar Producto
		vista.btnDelProd().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//Boton Nuevo Producto -- BORRA SELECCIÓN TABLA --
		vista.btnNewProduct().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//--------------------------------------------------------------
	}
	
	private static void cerrarVista() {
		vista.dispose();
	}
}
