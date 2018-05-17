package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.NuevoEditarProductoV;
import model.NuevoEditarProductoM;

public class NuevoEditarProductoC {
	
	private NuevoEditarProductoV newProd = null;
	private int stock = 0;
	private int idProd = 0;
	private double precio = 0.0;
	private String nombre = "";
	private String preciostring = "";
	private String stockstring = "";
	private int categoria = 0;
	private NuevoEditarProductoM model = null;
	
	public void nuevoProd() {
		newProd = new NuevoEditarProductoV();
		model = new NuevoEditarProductoM();
		
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
				categoria = newProd.comboBox().getSelectedIndex()+1;
				converToInt(preciostring, stockstring);
				model.newProd(nombre, stock, precio, categoria);
				cerrarVista();
			}
		});
	}
	
	public void editProd(Integer id, String nombr, double precio2, int stock2, Integer cat) {
		newProd = new NuevoEditarProductoV();
		model = new NuevoEditarProductoM();
		
		newProd.tfNombre().setText(nombr);
		newProd.tfStock().setText((String) ""+stock2);
		newProd.tfPrecio().setText((String) ""+precio2);
		newProd.comboBox().setSelectedIndex(cat - 1);
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
				model.editProd(nombre, stock,  precio, categoria+1, idProd);
				cerrarVista();
			}
		});
	}
	
	public void cerrarVista() {
		newProd.dispose();
	}
	
	public void converToInt(String precios, String stocks) {
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
