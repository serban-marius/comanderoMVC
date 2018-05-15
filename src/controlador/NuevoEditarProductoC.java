package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.NuevoEditarCategoriaV;
import vista.NuevoEditarProductoV;

public class NuevoEditarProductoC {
	private static NuevoEditarProductoV newProd = null;
	private static int stock = 0;
	private static double precio = 0.0;
	private static String nombre = "";
	private static String preciostring = "";
	private static String stockstring = "";
	
	public static void nuevoProd() {
		newProd = new NuevoEditarProductoV();
		
		//Eventos de la ventana
		// ---- BOTON VOLVER ----------
		newProd.btnVolver().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVista();
			}
		});
		// ----- BOTON GUARDAR CATEGORÍA
		newProd.btnSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombre = newProd.tfNombre().getText();
				preciostring = newProd.tfPrecio().getText();
				stockstring = newProd.tfStock().getText();
				converToInt(preciostring, stockstring);
				//Llamada a metodo del Modelo para introducir en BD
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
