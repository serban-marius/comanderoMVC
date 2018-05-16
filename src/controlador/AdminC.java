package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import vista.AdminV;
import model.AdminM;
import controlador.NuevoEditarProductoC;
import controlador.NuevoEditarCategoriaC;
import model.NuevoEditarCategoriaM;
import model.NuevoEditarProductoM;

public class AdminC {
	private static AdminV vista = null;
	private static Integer id = null;
	
	public static void generarAdmin(){
		vista = new AdminV();
		getId();
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
				vista.revalidate();
			}
		});
		//Botón Eliminar Mesa
		vista.btnDelMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminM.delMesa(getId());
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
				AdminM.delCat(getIdCat());
			}
		});
		//Botón Modificar Categoría
		vista.btnEditCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoEditarCategoriaC.editCat(getIdCat(), NuevoEditarCategoriaM.nombreCat());
			}
		});
		
		//---------------------------------------------------------------
		
		// --------------------- BOTONES PRODUCTOS ----------------------
		//Boton Nuevo Producto
		vista.btnNewProduct().addActionListener(new ActionListener() {
			@Override
		  	public void actionPerformed(ActionEvent e) {
				System.out.println("hey");
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
				NuevoEditarProductoC.editProd(0);
			}
		});
		
		//--------------------------------------------------------------
	}
	
	private static void cerrarVista() {
		vista.dispose();
	}
	private static Integer getId() {
		AdminV.tablaMesas().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        String numero = AdminV.tablaMesas().getValueAt(AdminV.tablaMesas().getSelectedRow(), 0).toString();
		        id = Integer.parseInt(numero);
		        
		    }
		});
		return id;
	}
	private static Integer getIdCat() {
		AdminV.tableCat().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	try {
		        id = (int) AdminV.tableCat().getValueAt(AdminV.tableCat().getSelectedRow(), 0);
		    	}catch (Exception exe) {
		    		
		    	}
		    }
		});
		System.out.println(id);
		return id;
	}
}
