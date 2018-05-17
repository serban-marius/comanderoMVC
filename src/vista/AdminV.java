package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import model.AdminM;

public class AdminV extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTabbedPane panelDePestanas;
	private JTable tablaMesas;
	private JTable tableCat;
	private  JTable tableProductos;
	private JButton backButtonMesa;
	private JButton btnAddMesa;
	private JButton btnDelMesa;
	private JScrollPane scrollPaneMesas;
	private JButton btnEditCat;
	private JScrollPane scrollPaneCat;
	private JButton btnBackCat;
	private JButton btnDelCat;
	private JButton btnEditProd;
	private JScrollPane scrollPaneTablaProd;
	private JButton btnDelProd;
	private JButton btnBack;
	private JButton btnNewCategory;
	private JButton btnNewProduct;
	private JButton btnRefrescarCat;
	private JButton btnRefresh;
	private JComboBox<String> comboBox;
	private AdminM model = null;
	
	public AdminV() {
		  model = new AdminM();
		
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
		  tablaMesas.setModel(model.getModelMesas());
		  scrollPaneMesas.setViewportView(tablaMesas);
		  
		  //---------------------------------------------
		  
		  //Segunda pestaña CATEGORIAS
		  panel2 = new JPanel();
		  panelDePestanas.addTab("Categor\u00EDas", null, panel2, null);
		  panel2.setLayout(null);
		  
		  btnEditCat = new JButton("Editar Categor\u00EDa");
		  btnEditCat.setBounds(226, 295, 169, 48);
		  panel2.add(btnEditCat);
		  
		  scrollPaneCat = new JScrollPane();
		  scrollPaneCat.setBounds(10, 11, 485, 273);
		  panel2.add(scrollPaneCat);
		  
		  tableCat = new JTable();
		  tableCat.setModel(model.getModelCategorias());
		  scrollPaneCat.setViewportView(tableCat);
		  
		  btnBackCat = new JButton("Volver");
		  btnBackCat.setBounds(10, 350, 599, 30);
		  panel2.add(btnBackCat);
		  
		  btnDelCat = new JButton("Eliminar Categor\u00EDa");
		  btnDelCat.setBounds(440, 295, 169, 48);
		  panel2.add(btnDelCat);
		  
		  btnNewCategory = new JButton("Categor\u00EDa Nueva");
		  btnNewCategory.setBounds(10, 295, 169, 48);
		  panel2.add(btnNewCategory);
		  
		  btnRefrescarCat = new JButton("Refrescar");
		  btnRefrescarCat.setBounds(505, 11, 104, 273);
		  panel2.add(btnRefrescarCat);
		  
		  //---------------------------------------------
		  
		  //Tercera pestaña PRODUCTOS
		  panel3 = new JPanel();
		  panelDePestanas.addTab("Productos", null, panel3, null);
		  panel3.setLayout(null);
		  
		  btnEditProd = new JButton("Editar Producto");
		  btnEditProd.setBounds(221, 298, 165, 46);
		  panel3.add(btnEditProd);
		  
		  scrollPaneTablaProd = new JScrollPane();
		  scrollPaneTablaProd.setBounds(10, 11, 481, 276);
		  panel3.add(scrollPaneTablaProd);
		  
		  tableProductos = new JTable();
		  tableProductos.setModel(model.getModelProductos());
		  scrollPaneTablaProd.setViewportView(tableProductos);
		  
		  btnDelProd = new JButton("Eliminar Producto");
		  btnDelProd.setBounds(444, 298, 165, 46);
		  panel3.add(btnDelProd);
		  
		  btnBack = new JButton("Volver");
		  btnBack.setBounds(10, 351, 599, 29);
		  panel3.add(btnBack);
		  
		  btnNewProduct = new JButton("Producto Nuevo");
		  btnNewProduct.setBounds(10, 298, 165, 46);
		  panel3.add(btnNewProduct);
		  
		  btnRefresh = new JButton("Refescar Datos");
		  btnRefresh.setBounds(501, 8, 108, 279);
		  panel3.add(btnRefresh);
		  
		  /*comboBox = new JComboBox<String>();
		  comboBox.setModel(model.getComboBoxModelCategorias());
		  comboBox.setBounds(10, 11, 599, 28);
		  panel3.add(comboBox);*/
		  
		  setVisible(true);
		  
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
	public JTable tableCat() {
		return tableCat;
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
	public JButton btnEditCat() {
		return btnEditCat;
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
	public JButton btnEditProd() {
		return btnEditProd;
	}
	public JScrollPane scrollPaneTablaProd() {
		return scrollPaneTablaProd;
	}
	public JButton btnDelProd() {
		return btnDelProd;
	}
	public JButton btnBack() {
		return btnBack;
	}
	public JButton btnNewCategory() {
		return btnNewCategory;
	}
	public JButton btnNewProduct() {
		return btnNewProduct;
	}
	public JComboBox<String> comboBox() {
		return comboBox;
	}
	public JButton btnRefrescarCat() {
		return btnRefrescarCat;
	}
	public JButton btnRefresh() {
		return btnRefresh;
	}
}
