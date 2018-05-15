package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AdminV;
import model.AdminM;
import controlador.NuevoEditarProductoC;
import controlador.NuevoEditarCategoriaC;
import model.NuevoEditarCategoriaM;
import model.NuevoEditarProductoM;

public class AdminC {
	private static AdminV vista = null;
	
	public static void generarAdmin(){
		vista = new AdminV();
		// Eventos de la ventana
		// ----------------------- BOTONES VOLVER (HECHO) --------------------------
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
		
		// ------------------------- BOTONES MESAS  -------------------------
		//Botón Añadir Mesa
		vista.btnAddMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminM.addMesa();
			}
		});
		//Botón Eliminar Mesa
		vista.btnDelMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminM.delMesa();
			}
		});
		// ---------------------------------------------------------------
		
		// ---------------------- BOTONES CATEGORIAS ---------------------
		//Botón Nueva Categoría
		vista.btnNewCategory().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.nuevaCat();
			}
		});
		//Botón Eliminar Categoría 
		vista.btnDelCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminM.delCat(NuevoEditarCategoriaM.numeroCat());
			}
		});
		//Botón Modificar Categoría
		vista.btnEditCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.editCat(NuevoEditarCategoriaM.numeroCat(), NuevoEditarCategoriaM.nombreCat());
			}
		});
		
		//---------------------------------------------------------------
		
		// --------------------- BOTONES PRODUCTOS ----------------------
		//Boton Nuevo Producto -- BORRA SELECCIÓN TABLA --
		vista.btnNewProduct().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarProductoC.nuevoProd();
			}
		});
		//Boton Eliminar Producto
		vista.btnDelProd().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminM.delProd(NuevoEditarProductoM.idProd());
			}
		});
		// Boton Modificar Producto 
		vista.btnEditProd().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarProductoC.editProd();
			}
		});
		
		//--------------------------------------------------------------
	}
	
	private static void cerrarVista() {
		vista.dispose();
	}
}
