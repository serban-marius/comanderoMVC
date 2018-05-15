package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoEditarProductoV extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField tfStock;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JLabel lblCategora;
	private JComboBox<String> comboBox;
	private JButton btnSave;
	private JButton btnVolver;
	
	public NuevoEditarProductoV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 165);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombre);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 36, 46, 14);
		contentPane.add(lblPrecio);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(66, 8, 181, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(66, 33, 181, 20);
		contentPane.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(257, 11, 46, 14);
		contentPane.add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setBounds(313, 8, 242, 20);
		contentPane.add(tfStock);
		tfStock.setColumns(10);
		
		lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(255, 36, 58, 14);
		contentPane.add(lblCategora);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(313, 33, 242, 20);
		contentPane.add(comboBox);
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(10, 61, 237, 56);
		contentPane.add(btnSave);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(313, 61, 242, 56);
		contentPane.add(btnVolver);
		
		setVisible(true);
	}
	public JTextField tfNombre() {
		return tfNombre;
	}
	public JTextField tfPrecio() {
		return tfPrecio;
	}
	public JTextField tfStock() {
		return tfStock;
	}
	public JButton btnSave() {
		return btnSave;
	}
	public JButton btnVolver() {
		return btnVolver;
	}
	public JComboBox<String> comboBox(){
		return comboBox;
	}
}
