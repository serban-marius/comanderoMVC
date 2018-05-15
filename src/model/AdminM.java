package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminM {
	public static TableModel getModelMesas() {
		
		String[] columnasModel = {"ID"};
		DefaultTableModel model = new DefaultTableModel(null, columnasModel) {
			private static final long serialVersionUID = 1L;
				Class<?>[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, String.class
				};
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		
		Object[] rowData = new Object[columnasModel.length];
		
		conexionDB.openConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
		
			statement = conexionDB.getConnection().createStatement();
			resultSet = statement.executeQuery("select * from " + conexionDB.getDatabase() + ".mesa order by id_mesa asc");
			
			while(resultSet.next()) {
				rowData[0] = resultSet.getInt("id_mesa");
				model.addRow(rowData);
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

	public static void addMesa() {
		TableModel tableModel = AdminM.getModelMesas();
		int nextId = (int) tableModel.getValueAt(tableModel.getRowCount() - 1, 0) + 1;
		String sql = "insert into " + conexionDB.getDatabase() + ".mesa values (" + nextId + ", 'LIBRE', '0')";
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
	
	public static void delMesa() {
		//Metodo para borrar mesa
	}
	
	public static void delCat(int id) {
		//Metodo para eliminar categoria
	}
	
	public static void delProd(int id) {
		//Metodo para eliminar producto
	}
}
