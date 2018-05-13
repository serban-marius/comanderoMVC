import controlador.AdminC;

public class main {

	public static void main(String[] args) {
		//InicioC x = new InicioC();
		//x.generarInicio();
		
		AdminC x = new AdminC();
		x.generarAdmin();
	    
	}
	
	/* CODIGO PARA ABRIR UN SELECTOR DE ARCHIVOS
	public static string {
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	        System.out.println("You chose to open this file: " +
	                chooser.getSelectedFile().getName());
	    }
    return chooser.getSelectedFile();
    }
    */

}
