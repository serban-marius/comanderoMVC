package model;

public class NuevoEditarProductoM {
	
	public static int idProd() {
		//Metodo para sacar id Producto de la BD
		return 1;
	}
	public static String nombreProd() {
		//Metodo para sacar nombre Producto de la BD
		return "Nombre producto";
	}
	public static String stockProducto() {
		//Metodo para sacar stock de un Producto de a BD
		return "10";
	}
	public static String precioProducto() {
		//Metodo para sacar el precio de un Producto de la BD
		return "1.0";
	}
	public static int idCat() {
		//Metodo para devolver categoría de un producto de la BD
		return 0;
	}

	public static void newProd(String nombre, int stock, double precio, int id) {
		//Metodo producto nuevo a la DB
	}
	
	public static void editProd(String nombre, int stock, double precio, int idCat, int idProd) {
		//Metodo editar producto de la DB
	}
}
