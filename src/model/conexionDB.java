package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class conexionDB {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String driverType = "thin";
	private static String host;
	private static int port = 1521;
	private static String sid = "XE";
	private static String user;
	private static String pass;
	private static String database;
	private static String url = null;
	private static Connection connection = null;
	
	private conexionDB() {}
	
	public static void openConnection() {
		extractFileConnectionData();
		try{
			Class.forName(conexionDB.driver);
			conexionDB.url = "jdbc:oracle:" + conexionDB.driverType + ":@" + conexionDB.host + ":" + conexionDB.port + ":" + conexionDB.sid;
			conexionDB.connection = DriverManager.getConnection(conexionDB.url, conexionDB.user, conexionDB.pass);
			conexionDB.checkConnection();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try{
			conexionDB.connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkConnection() {
		try{
			if(conexionDB.connection.isClosed()) {
				System.out.println("ATENCION: la conexion con la BBDD se encuentra cerrada");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void extractFileConnectionData() {
	    Properties properties = new Properties();
	    InputStream fileInputStream = null;
	    try{
	    	fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/model/conexionDB.properties");
	        //cargamos los datos del archivo
	    	properties.load(fileInputStream);
	    	conexionDB.host = properties.getProperty("dbhost");
	    	conexionDB.user = properties.getProperty("dbuser");
	    	conexionDB.pass = properties.getProperty("dbpassword");
	    	conexionDB.database = properties.getProperty("dbname");
	    }catch (IOException ex) {
	    	System.out.println("CREDENCIALES/ESTRUCTURA ERRONEA --> conexionDB.properties");
	        ex.printStackTrace();
	    }finally {
	        if (fileInputStream != null) {
	            try {
	            	fileInputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	public static Connection getConnection() {
		return conexionDB.connection;
	}
	
	public static String getDatabase() {
		return conexionDB.database;
	}
	
}
