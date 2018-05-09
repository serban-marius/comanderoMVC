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

public class AdminV extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane panelDePestanas;
	private JTable tablaMesas;
	private JTextField textField;
	
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
		  JPanel panel1 = new JPanel();
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
		  JPanel panel2 = new JPanel();
		  panelDePestanas.addTab("Categorias", null, panel2, null);
		  panel2.setLayout(null);
		  
		  JLabel lblNewLabel = new JLabel("Nombre ");
		  lblNewLabel.setBounds(10, 11, 46, 14);
		  panel2.add(lblNewLabel);
		  
		  textField = new JTextField();
		  textField.setBounds(66, 8, 173, 20);
		  panel2.add(textField);
		  textField.setColumns(10);
		  
		  //---------------------------------------------
		 }
}
