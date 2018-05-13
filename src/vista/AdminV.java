package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class AdminV extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTabbedPane panelDePestanas;
	private JTable tablaMesas;
	private JTextField textFieldNameCat;
	private JTable tableCat;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldStock;
	private JTable tableProductos;
	private JButton backButtonMesa;
	private JButton btnAddMesa;
	private JButton btnDelMesa;
	private JScrollPane scrollPaneMesas;
	private JLabel lblNameCat;
	private JLabel lblImagen;
	private JButton btnSelectImg;
	private JButton btnAddSaveCat;
	private JScrollPane scrollPaneCat;
	private JButton btnBackCat;
	private JButton btnDelCat;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JLabel lblImagen_1;
	private JButton btnSelectImag;
	private JButton btnSaveEditProd;
	private JScrollPane scrollPaneTablaProd;
	private JButton btnDelProd;
	private JLabel lblseguro;
	private JButton btnYesProd;
	private JButton btnNoProd;
	private JButton btnBack;
	
	public AdminV() {
		  
		  setTitle("Panel de Administración");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(100, 100, 640, 458);
		  
		  contentPane = new JPanel();
		  setContentPane(contentPane);
		  contentPane.setLayout(null); //Está distribucion nos perimte colocar los objetos donde queramos!!
		  
		  panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		  panelDePestanas.setBounds(0, 0, 624, 419);
		  contentPane.add(panelDePestanas);
		  
		  //Primera pestaña MESAS
		  panel1 = new JPanel();
		  panelDePestanas.addTab("Mesas", null, panel1, null);
		  panel1.setLayout(null);
		  
		  backButtonMesa = new JButton("Volver");
		  backButtonMesa.setBounds(10, 350, 599, 30);
		  panel1.add(backButtonMesa);
		  
		  btnAddMesa = new JButton("A\u00F1adir Mesa");
		  btnAddMesa.setBounds(10, 293, 291, 46);
		  panel1.add(btnAddMesa);
		  
		  btnDelMesa = new JButton("Eliminar Mesa");
		  btnDelMesa.setBounds(318, 293, 291, 46);
		  panel1.add(btnDelMesa);
		  
		  scrollPaneMesas = new JScrollPane();
		  scrollPaneMesas.setBounds(10, 11, 599, 271);
		  panel1.add(scrollPaneMesas);
		  
		  tablaMesas = new JTable();
		  scrollPaneMesas.setViewportView(tablaMesas);
		  tablaMesas.setModel(new DefaultTableModel(
		  	new Object[][] {
		  		{null, null, null},
		  		{null, null, null},
		  		{null, null, null},
		  		{null, null, null},
		  		{null, null, null},
		  		{null, null, null},
		  	},
		  	new String[] {
		  		"New column", "New column", "New column"
		  	}
		  ));
		  
		  //---------------------------------------------
		  
		  //Segunda pestaña CATEGORIAS
		  panel2 = new JPanel();
		  panelDePestanas.addTab("Categorias", null, panel2, null);
		  panel2.setLayout(null);
		  
		  lblNameCat = new JLabel("Nombre ");
		  lblNameCat.setBounds(10, 11, 46, 14);
		  panel2.add(lblNameCat);
		  
		  textFieldNameCat = new JTextField();
		  textFieldNameCat.setBounds(66, 8, 173, 20);
		  panel2.add(textFieldNameCat);
		  textFieldNameCat.setColumns(10);
		  
		  lblImagen = new JLabel("Imagen");
		  lblImagen.setBounds(10, 36, 46, 14);
		  panel2.add(lblImagen);
		  
		  btnSelectImg = new JButton("Seleccionar Imagen");
		  btnSelectImg.setBounds(66, 32, 173, 23);
		  panel2.add(btnSelectImg);
		  
		  btnAddSaveCat = new JButton("A\u00F1adir/Modificar");
		  btnAddSaveCat.setBounds(261, 7, 163, 48);
		  panel2.add(btnAddSaveCat);
		  
		  scrollPaneCat = new JScrollPane();
		  scrollPaneCat.setBounds(10, 61, 599, 278);
		  panel2.add(scrollPaneCat);
		  
		  tableCat = new JTable();
		  tableCat.setModel(new DefaultTableModel(
		  	new Object[][] {
		  		{null, null},
		  	},
		  	new String[] {
		  		"New column", "New column"
		  	}
		  ));
		  scrollPaneCat.setViewportView(tableCat);
		  
		  btnBackCat = new JButton("Volver");
		  btnBackCat.setBounds(10, 350, 599, 30);
		  panel2.add(btnBackCat);
		  
		  btnDelCat = new JButton("Eliminar");
		  btnDelCat.setBounds(446, 7, 163, 48);
		  panel2.add(btnDelCat);
		  
		  //---------------------------------------------
		  
		  //Tercera pestaña PRODUCTOS
		  panel3 = new JPanel();
		  panelDePestanas.addTab("Productos", null, panel3, null);
		  panel3.setLayout(null);
		  
		  lblNombre = new JLabel("Nombre");
		  lblNombre.setBounds(10, 11, 46, 14);
		  panel3.add(lblNombre);
		  
		  lblPrecio = new JLabel("Precio");
		  lblPrecio.setBounds(10, 36, 46, 14);
		  panel3.add(lblPrecio);
		  
		  lblStock = new JLabel("Stock");
		  lblStock.setBounds(225, 11, 46, 14);
		  panel3.add(lblStock);
		  
		  lblImagen_1 = new JLabel("Imagen");
		  lblImagen_1.setBounds(225, 36, 46, 14);
		  panel3.add(lblImagen_1);
		  
		  textFieldNombre = new JTextField();
		  textFieldNombre.setBounds(54, 8, 161, 20);
		  panel3.add(textFieldNombre);
		  textFieldNombre.setColumns(10);
		  
		  textFieldPrecio = new JTextField();
		  textFieldPrecio.setBounds(54, 33, 161, 20);
		  panel3.add(textFieldPrecio);
		  textFieldPrecio.setColumns(10);
		  
		  textFieldStock = new JTextField();
		  textFieldStock.setBounds(281, 8, 161, 20);
		  panel3.add(textFieldStock);
		  textFieldStock.setColumns(10);
		  
		  btnSelectImag = new JButton("Seleccionar Imagen");
		  btnSelectImag.setBounds(281, 32, 161, 23);
		  panel3.add(btnSelectImag);
		  
		  btnSaveEditProd = new JButton("Guardar/Editar");
		  btnSaveEditProd.setBounds(452, 7, 157, 46);
		  panel3.add(btnSaveEditProd);
		  
		  scrollPaneTablaProd = new JScrollPane();
		  scrollPaneTablaProd.setBounds(10, 61, 599, 239);
		  panel3.add(scrollPaneTablaProd);
		  
		  tableProductos = new JTable();
		  scrollPaneTablaProd.setViewportView(tableProductos);
		  
		  btnDelProd = new JButton("Eliminar Producto");
		  btnDelProd.setBounds(73, 311, 142, 29);
		  panel3.add(btnDelProd);
		  
		  lblseguro = new JLabel("\u00BFSeguro?");
		  lblseguro.setForeground(Color.RED);
		  lblseguro.setBounds(260, 318, 46, 14);
		  panel3.add(lblseguro);
		  
		  btnYesProd = new JButton("SI");
		  btnYesProd.setBounds(316, 311, 113, 29);
		  panel3.add(btnYesProd);
		  
		  btnNoProd = new JButton("NO");
		  btnNoProd.setBounds(452, 311, 113, 29);
		  panel3.add(btnNoProd);
		  
		  btnBack = new JButton("Volver");
		  btnBack.setBounds(10, 351, 599, 29);
		  panel3.add(btnBack);
		  
		 }
	public JPanel contentPane() {
		return contentPane;
	}
	
	public JPanel panel1() {
		return panel1;
	}
	
	public JPanel panel2() {
		return panel2;
	}
	public JPanel panel3() {
		return panel3;
	}
	public JTabbedPane panelDePestanas() {
		return panelDePestanas;
	}
	public JTable tablaMesas() {
		return tablaMesas;
	}
	public JTextField textFieldNameCat() {
		return textFieldNameCat;
	}
	public JTable tableCat() {
		return tableCat;
	}
	public JTextField textFieldNombre() {
		return textFieldNombre;
	}
	public JTextField textFieldPrecio() {
		return textFieldPrecio;
	}
	public JTextField textFieldStock() {
		return textFieldStock;
	}
	public JTable tableProductos() {
		return tableProductos;
	}
	public JButton backButtonMesa() {
		return backButtonMesa;
	}
	public JButton btnAddMesa() {
		return btnAddMesa;
	}
	public JButton btnDelMesa() {
		return btnDelMesa;
	}
	public JScrollPane scrollPaneMesas() {
		return scrollPaneMesas;
	}
	public JLabel lblNameCat() {
		return lblNameCat;
	}
	public JLabel lblImagen() {
		return lblImagen;
	}
	public JButton btnSelectImg() {
		return btnSelectImg;
	}
	public JButton btnAddSaveCat() {
		return btnAddSaveCat;
	}
	public JScrollPane scrollPaneCat() {
		return scrollPaneCat;
	}
	public JButton btnBackCat() {
		return btnBackCat;
	}
	public JButton btnDelCat() {
		return btnDelCat;
	}
	public JLabel lblNombre() {
		return lblNombre;
	}
	public JLabel lblPrecio() {
		return lblPrecio;
	}
	public JLabel lblStock() {
		return lblStock;
	}
	public JLabel lblImagen_1() {
		return lblImagen_1;
	}
	public JButton btnSelectImag() {
		return btnSelectImag;
	}
	public JButton btnSaveEditProd() {
		return btnSaveEditProd;
	}
	public JScrollPane scrollPaneTablaProd() {
		return scrollPaneTablaProd;
	}
	public JButton btnDelProd() {
		return btnDelProd;
	}
	public JLabel lblseguro() {
		return lblseguro;
	}
	public JButton btnYesProd() {
		return btnYesProd;
	}
	public JButton btnNoProd() {
		return btnNoProd;
	}
	public JButton btnBack() {
		return btnBack;
	}
}
