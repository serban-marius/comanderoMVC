package vista;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class AdminV extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane panelDePestanas;
	
	public AdminV() {
		  
		  setTitle("Panel de Administración");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(100, 100, 419, 234);
		  
		  Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		  contentPane.setBorder(raisedbevel);
		  contentPane = new JPanel();
		  setContentPane(contentPane);
		  contentPane.setLayout(null); //Está distribucion nos perimte colocar los objetos donde queramos!!
		  
		  panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		  // se posiciona en el panel
		  panelDePestanas.setBounds(10, 11, 383, 174);
		  contentPane.add(panelDePestanas);
		  
		  // éste es el primer panel
		  // que se añade como pestaña al 'tabbedPane'
		  JPanel panel1 = new JPanel();
		  panelDePestanas.addTab("Mesas", null, panel1, null);
		  // al panel le pongo distribución nula para
		  // posicionar los elementos en las coordenadas que
		  // quiera
		  panel1.setLayout(null);
		  
		  // una etiqueta en el panel de la pestaña 1
		  JLabel lbl1 = new JLabel("Mesas");
		  lbl1.setBounds(10, 11, 348, 14);
		  panel1.add(lbl1);
		  
		  // otro panel de igual forma
		  JPanel panel2 = new JPanel();
		  panelDePestanas.addTab("Categorias", null, panel2, null);
		  panel2.setLayout(null);
		  
		  // otra etiqueta ésta vez en el segundo panel
		  JLabel lbl2 = new JLabel("Categorias");
		  lbl2.setBounds(10, 11, 290, 14);
		  panel2.add(lbl2);
		 }
}
