package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import vista.AdminV;
import model.AdminM;
import controlador.NuevoEditarProductoC;
import controlador.NuevoEditarCategoriaC;

public class AdminC {
	private AdminV vista = null;
	private AdminM model = null;
	private NuevoEditarCategoriaC editCat = null;
	private NuevoEditarProductoC editProd = null;
	private Integer idMesa = null;
	private Integer idCat = null;
	private Integer idProd = null;
	
	public void generarAdmin(){
		model = new AdminM();
		vista = new AdminV();
		editCat = new NuevoEditarCategoriaC();
		editProd = new NuevoEditarProductoC();
		
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
				model.addMesa();
				vista.tablaMesas().setModel(model.getModelMesas());
			}
		});
		//Botón Eliminar Mesa
		vista.btnDelMesa().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) vista.tablaMesas().getModel();

				idMesa = (int) tableModel.getValueAt(vista.tablaMesas().getSelectedRow(), 0);
				
				model.delMesa(idMesa);
				
				vista.tablaMesas().setModel(model.getModelMesas());
			}
		});
		
		// ---------------------------------------------------------------
		
		// ---------------------- BOTONES CATEGORIAS ---------------------
		//Botón Nueva Categoría
		vista.btnNewCategory().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				editCat.nuevaCat();
			}
		});
		//Botón Eliminar Categoría 
		vista.btnDelCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) vista.tableCat().getModel();

				idCat = (int) tableModel.getValueAt(vista.tableCat().getSelectedRow(), 0);
				
				model.delCat(idCat);
				
				vista.tableCat().setModel(model.getModelCategorias());
			}
		});
		//Botón Modificar Categoría
		vista.btnEditCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) vista.tableCat().getModel();

				idCat = (int) tableModel.getValueAt(vista.tableCat().getSelectedRow(), 0);
				String nombreCat = (String) tableModel.getValueAt(vista.tableCat().getSelectedRow(), 1);
				editCat.editCat(idCat, nombreCat);
			}
		});
		//Botón Refrescar Categorias
		vista.btnRefrescarCat().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				vista.tableCat().setModel(model.getModelCategorias());
			}
		});
		
		//---------------------------------------------------------------
		
		// --------------------- BOTONES PRODUCTOS ----------------------
		//Boton Nuevo Producto
		vista.btnNewProduct().addActionListener(new ActionListener() {
			@Override
		  	public void actionPerformed(ActionEvent e) {
				editProd.nuevoProd();
		  	}
		});
		//Boton Eliminar Producto
		vista.btnDelProd().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) vista.tableProductos().getModel();

				idProd = (int) tableModel.getValueAt(vista.tableProductos().getSelectedRow(), 0);
				
				model.delProd(idProd);
				
				vista.tableProductos().setModel(model.getModelProductos());
				
			}
		});
		// Boton Modificar Producto 
		vista.btnEditProd().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) vista.tableProductos().getModel();

				idProd = (int) tableModel.getValueAt(vista.tableProductos().getSelectedRow(), 0);
				String nombre = (String) tableModel.getValueAt(vista.tableProductos().getSelectedRow(), 1);
				double precio = (double) tableModel.getValueAt(vista.tableProductos().getSelectedRow(), 2);
				int stock = (int) tableModel.getValueAt(vista.tableProductos().getSelectedRow(), 3);
				idCat = model.getIdCat((String) tableModel.getValueAt(vista.tableProductos().getSelectedRow(), 4));
				
				editProd.editProd(idProd, nombre, precio, stock, idCat);
				
				vista.tableProductos().setModel(model.getModelProductos());
			}
		});
		//Boton Refrescar Productos
		vista.btnRefresh().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
							
				vista.tableProductos().setModel(model.getModelProductos());
				
			}
		});
		
		//--------------------------------------------------------------
	}
	
	private void cerrarVista() {
		vista.dispose();
	}
}
