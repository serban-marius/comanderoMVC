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
		//Bot�n A�adir Mesa
		vista.btnAddMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodo del modelo para a�adir mesa
			}
		});
		//Bot�n Eliminar Mesa
		vista.btnDelMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodo del modelo para eliminar mesa
			}
		});
		// ---------------------------------------------------------------
		
		// ---------------------- BOTONES CATEGORIAS ---------------------
		//Bot�n Modificar Categor�a
		vista.btnAddSaveCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.editCat(NuevoEditarCategoriaM.numeroCat(), NuevoEditarCategoriaM.nombreCat());
			}
		});
		//Bot�n Eliminar Categor�a 
		vista.btnDelCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaM.delCat(NuevoEditarCategoriaM.numeroCat());
			}
		});
		//Bot�n Nueva Categor�a -- BORRA SELECCI�N TABLA --
		vista.btnNewCategory().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.nuevaCat();
			}
		});
		//---------------------------------------------------------------
		
		// --------------------- BOTONES PRODUCTOS ----------------------
		// Boton A�adir/Modificar Producto 
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
		//Boton Nuevo Producto -- BORRA SELECCI�N TABLA --
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
