package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminV extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTabbedPane panelDePestanas;
	private JTable tablaMesas;
	private JTextField textFieldNameCat;
	private JTable table;
	
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
		  
		  JButton backButtonMesa = new JButton("Volver");
		  backButtonMesa.setBounds(10, 350, 599, 30);
		  panel1.add(backButtonMesa);
		  
		  JButton btnSaveMesa = new JButton("Guardar Cambios");
		  btnSaveMesa.setBounds(431, 293, 178, 46);
		  panel1.add(btnSaveMesa);
		  
		  JButton btnAddMesa = new JButton("A\u00F1adir Mesa");
		  btnAddMesa.setBounds(10, 293, 178, 46);
		  panel1.add(btnAddMesa);
		  
		  JButton btnDelMesa = new JButton("Eliminar Mesa");
		  btnDelMesa.setBounds(198, 293, 223, 46);
		  panel1.add(btnDelMesa);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(10, 11, 599, 271);
		  panel1.add(scrollPane);
		  
		  tablaMesas = new JTable();
		  scrollPane.setViewportView(tablaMesas);
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
		  
		  JLabel lblNameCat = new JLabel("Nombre ");
		  lblNameCat.setBounds(10, 11, 46, 14);
		  panel2.add(lblNameCat);
		  
		  textFieldNameCat = new JTextField();
		  textFieldNameCat.setBounds(66, 8, 173, 20);
		  panel2.add(textFieldNameCat);
		  textFieldNameCat.setColumns(10);
		  
		  JLabel lblImagen = new JLabel("Imagen");
		  lblImagen.setBounds(10, 36, 46, 14);
		  panel2.add(lblImagen);
		  
		  JButton btnSelectImg = new JButton("Seleccionar Imagen");
		  btnSelectImg.setBounds(66, 32, 173, 23);
		  panel2.add(btnSelectImg);
		  
		  JButton btnAddSaveCat = new JButton("A\u00F1adir/Modificar");
		  btnAddSaveCat.setBounds(261, 7, 163, 48);
		  panel2.add(btnAddSaveCat);
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(10, 61, 599, 278);
		  panel2.add(scrollPane_1);
		  
		  table = new JTable();
		  table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  		{null, null},
		  	},
		  	new String[] {
		  		"New column", "New column"
		  	}
		  ));
		  scrollPane_1.setViewportView(table);
		  
		  JButton btnBackCat = new JButton("Volver");
		  btnBackCat.setBounds(10, 350, 599, 30);
		  panel2.add(btnBackCat);
		  
		  JButton btnDelCat = new JButton("Eliminar");
		  btnDelCat.setBounds(446, 7, 163, 48);
		  panel2.add(btnDelCat);
		  
		  //---------------------------------------------
		  
		  //Tercera pestaña PRODUCTOS
		  panel3 = new JPanel();
		  panelDePestanas.addTab("Productos", null, panel3, null);
		  panel3.setLayout(null);
		  
		  JButton btnNewButton = new JButton();
		  btnNewButton.setIcon(new ImageIcon("m.png"));
		  panel3.add(btnNewButton);
		  
		 }
	
}
