package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.NuevoEditarProductoV;
import model.NuevoEditarProductoM;

public class NuevoEditarProductoC {
	
	private static NuevoEditarProductoV newProd = null;
	private static int stock = 0;
	private static int idProd = 0;
	private static double precio = 0.0;
	private static String nombre = "";
	private static String preciostring = "";
	private static String stockstring = "";
	private static int categoria = 0;
	
	public void nuevoProd() {
		newProd = new NuevoEditarProductoV();
		
		//Eventos de la ventana
		// ---- BOTON VOLVER ----------
		newProd.btnVolver().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		// ----- BOTON GUARDAR PRODUCTO
		newProd.btnSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombre = newProd.tfNombre().getText();
				preciostring = newProd.tfPrecio().getText();
				stockstring = newProd.tfStock().getText();
				categoria = newProd.comboBox().getSelectedIndex();
				converToInt(preciostring, stockstring);
				NuevoEditarProductoM.newProd(nombre,stock,precio,categoria);
			}
		});
	}
	
	public void editProd(int id) {
		newProd = new NuevoEditarProductoV();
		
		newProd.tfNombre().setText(NuevoEditarProductoM.nombreProd());
		newProd.tfStock().setText(NuevoEditarProductoM.stockProducto());
		newProd.tfPrecio().setText(NuevoEditarProductoM.precioProducto());
		newProd.comboBox().setSelectedIndex(NuevoEditarProductoM.idCat());
		idProd = id;
		
		//Eventos de la ventana
		// ---- BOTON VOLVER ----------
		newProd.btnVolver().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		// ----- BOTON EDITAR PRODUCTO
		newProd.btnSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombre = newProd.tfNombre().getText();
				preciostring = newProd.tfPrecio().getText();
				stockstring = newProd.tfStock().getText();
				categoria = newProd.comboBox().getSelectedIndex();
				converToInt(preciostring, stockstring);
				NuevoEditarProductoM.editProd(nombre, stock,  precio, categoria, idProd);
			}
		});
	}
	
	public static void cerrarVista() {
		newProd.dispose();
	}
	
	public static void converToInt(String precios, String stocks) {
		try {
			precio = Double.parseDouble(preciostring);
		}catch(Exception e) {
			System.out.println("Precio Incorrecto");
		}
		try {
			stock = Integer.parseInt(stockstring);
		}catch(Exception e) {
			System.out.println("Stock Incorrecto");
		}
	}
	
}
