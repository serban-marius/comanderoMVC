package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.TableModel;

import model.AdminM;

public class NuevoEditarCategoriaM {
	private AdminM model = null;
	
	public void newCat(String newCat) {
		model = new AdminM();
		conexionDB.openConnection();
		TableModel tableModel = model.getModelCategorias();
		String sql = null;
		int nextId;
		
		try {
			nextId = (int) tableModel.getValueAt(tableModel.getRowCount() - 1, 0) + 1;
			sql = "insert into " + conexionDB.getDatabase() + ".categorias values (" + nextId + ", '" + newCat + "')";
		}catch (Exception e) {
			sql = "insert into " + conexionDB.getDatabase() + ".categorias values (" + 1 + ", '" + newCat + "')";
		}
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}

	public void editCat(int id, String nameCat) {
		// TODO Auto-generated method stub
		String sql = "update " + conexionDB.getDatabase() + ".categorias set nombre = '" + nameCat + "' where id = " + id;
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
}
