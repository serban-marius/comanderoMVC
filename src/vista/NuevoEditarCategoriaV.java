package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NuevoEditarCategoriaV extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNewCat;
	private JLabel lblNombreCategoria;
	private JButton btnSaveNewCategory;
	private JButton btnBacktoCat;
	
	public NuevoEditarCategoriaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 130);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombreCategoria = new JLabel("Nombre Categoria");
		lblNombreCategoria.setBounds(10, 11, 101, 14);
		contentPane.add(lblNombreCategoria);
		
		textNewCat = new JTextField();
		textNewCat.setBounds(121, 8, 349, 20);
		contentPane.add(textNewCat);
		textNewCat.setColumns(10);
		
		btnSaveNewCategory = new JButton("Guardar");
		btnSaveNewCategory.setBounds(10, 36, 218, 43);
		contentPane.add(btnSaveNewCategory);
		
		btnBacktoCat = new JButton("VOLVER");
		btnBacktoCat.setBounds(252, 36, 218, 43);
		contentPane.add(btnBacktoCat);
		
		setVisible(true);
	}
	
	public JTextField textNewCat() {
		return textNewCat;
	}
	public JButton btnSaveNewCategory() {
		return btnSaveNewCategory;
	}
	public JButton btnBacktoCat() {
		return btnBacktoCat;
	}
}
