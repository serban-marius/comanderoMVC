package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class InicioV extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCobro;
	private JButton btnAdmin;

	public InicioV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 324);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCobro = new JButton("Panel de COBRO");
		btnCobro.setBounds(10, 10, 460, 227);
		contentPane.add(btnCobro);

		btnAdmin = new JButton("Panel de ADMINISTRACION");
		btnAdmin.setBounds(10, 250, 460, 23);
		contentPane.add(btnAdmin);
		
		setVisible(true);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton btnCobro() {
		return btnCobro;
	}
	
	public JButton btnAdmin() {
		return btnAdmin;
	}
}