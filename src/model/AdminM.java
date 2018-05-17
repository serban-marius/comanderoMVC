package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminM {
	
	public TableModel getModelMesas() {
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
	public TableModel getModelCategorias() {
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
	
	public TableModel getModelProductos() {
		
		String[] columnasModel = {"ID", "Nombre", "Precio", "Stock", "Categoría"};
		DefaultTableModel model = new DefaultTableModel(null, columnasModel);
		
		Object[] rowData = new Object[columnasModel.length];
		
		conexionDB.openConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
		
			statement = conexionDB.getConnection().createStatement();
			resultSet = statement.executeQuery("select p.id_producto, p.nombre, p.precio, p.stock, c.nombre as categoria from " + conexionDB.getDatabase() + ".productos p, " + conexionDB.getDatabase() + ".categorias c where p.id_categoria = c.id order by p.id_producto asc");
			
			while(resultSet.next()) {
				rowData[0] = resultSet.getInt("id_producto");
				rowData[1] = resultSet.getString("nombre");
				rowData[2] = resultSet.getDouble("precio");
				rowData[3] = resultSet.getInt("stock");
				rowData[4] = resultSet.getString("categoria");
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

	public void addMesa() {
		TableModel tableModel = getModelMesas();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public void delMesa(int id) {
		String sql = "delete from " + conexionDB.getDatabase() + ".mesa where id_mesa = " + id;
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public void delCat(int id) {
		String sql = "delete from " + conexionDB.getDatabase() + ".categorias where id = " + id;
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public void delProd(int id) {
		String sql = "delete from " + conexionDB.getDatabase() + ".productos where id_producto = " + id;
		conexionDB.openConnection();
		Statement statement = null;
		try {
			statement = conexionDB.getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
		} finally {
		    try { if (statement != null) statement.close(); } catch (Exception e) {};
		    try { if (conexionDB.getConnection() != null) conexionDB.closeConnection(); } catch (Exception e) {};
		}
	}
	
	public Integer getIdCat(String valueAt) {
		conexionDB.openConnection();
		Statement statement;
		ResultSet resultSet;
		int id_category = -1;
		try {
			statement = conexionDB.getConnection().createStatement();
			resultSet = statement.executeQuery("select id from " + conexionDB.getDatabase() + ".categorias where nombre = '"+valueAt+"'");
			resultSet.next();
			id_category = resultSet.getInt("id");
		}catch (SQLException e) {}
		return id_category;
	}
}
