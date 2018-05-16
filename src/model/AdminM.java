package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import vista.AdminV;

public class AdminM {
	public static TableModel getModelMesas() {
		String[] columnasModel = {"ID", "Estado", "Total Cuenta"};
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
				rowData[1] = resultSet.getString("estado");
				rowData[2] = resultSet.getString("total");
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
	public static TableModel getModelCategorias() {
		String[] columnasModel = {"ID", "Nombre"};
		DefaultTableModel model = new DefaultTableModel(null, columnasModel) {
			private static final long serialVersionUID = 1L;
				Class<?>[] columnTypes = new Class[] {
						Integer.class, String.class
				};
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false
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
			resultSet = statement.executeQuery("select * from " + conexionDB.getDatabase() + ".categorias order by id asc");
			
			while(resultSet.next()) {
				rowData[0] = resultSet.getInt("id");
				rowData[1] = resultSet.getString("nombre");
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
		String sql = null;
		int nextId;
		
		try {
			nextId = (int) tableModel.getValueAt(tableModel.getRowCount() - 1, 0) + 1;
			sql = "insert into " + conexionDB.getDatabase() + ".mesa values (" + nextId + ", 'LIBRE', '0')";
		}catch (Exception e) {
			sql = "insert into " + conexionDB.getDatabase() + ".mesa values (1, 'LIBRE', '0')";
		}
		
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
			AdminV.tablaMesas().setModel(getModelMesas());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public static void delMesa(int id) {
		String sql = "delete from " + conexionDB.getDatabase() + ".mesa where id_mesa = " + id;
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
			AdminV.tablaMesas().setModel(getModelMesas());
		} catch (SQLException e) {
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public static void delCat(Integer id) {
		String sql = "delete from " + conexionDB.getDatabase() + ".categorias where id = " + id;
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
			AdminV.tableCat().setModel(AdminM.getModelCategorias());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public static void delProd(int id) {
		//Metodo para eliminar producto
	}
}
