package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
import model.AdminM;

public class NuevoEditarProductoM {
	private AdminM model;

	public ComboBoxModel<String> getComboBoxModelCategorias() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		conexionDB.openConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from " + conexionDB.getDatabase() + ".categorias order by id asc");
			while(resultSet.next()) {
				model.addElement(resultSet.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
		
		return model;
	}
	
	public void newProd(String nombre, int stock, double precio, int idCat) {
		model = new AdminM();
		TableModel tableModel = model.getModelProductos();
		String sql = null;
		Statement statement;
		int nextId;
		conexionDB.openConnection();
		
		try {
			nextId = (int) tableModel.getValueAt(tableModel.getRowCount() - 1, 0) + 1;
			System.out.println(nextId);
			sql = "insert into " + conexionDB.getDatabase() + ".productos values ("+nextId+", "+idCat+", '"+nombre+"', "+stock+", "+precio+")";	
		}catch (Exception e) {
			sql = "insert into " + conexionDB.getDatabase() + ".productos values ("+1+", "+idCat+", '"+nombre+"', "+stock+", "+precio+")";	
		}
			
		conexionDB.openConnection();
		 statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception exep) {};
		}
	}
	
	public void editProd(String nombre, int stock, double precio, int idCat, int idProd) {
		conexionDB.openConnection();
		Statement statement;
		
		String sql = "update " + conexionDB.getDatabase() + ".productos set nombre = '" + nombre + "',stock = " + stock + ", precio = " + precio + ", id_categoria = " + idCat + " where id_producto = " + idProd;		
		conexionDB.openConnection();
		 statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception exep) {};
		}
	}
}
