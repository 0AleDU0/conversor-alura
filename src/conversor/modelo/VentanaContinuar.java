package conversor.modelo;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaContinuar extends VentanaConversor{
	JPanel panel = new JPanel();
    JButton opcion1 = new JButton(" Yes ");
    JButton opcion2 = new JButton(" No ");

	public VentanaContinuar(String titulo, String descripcionVentana, Integer icono) {
		super(titulo, descripcionVentana, icono);
	}
	/**
	 * mensaje si el usuario desea continuar con el programa
	 * @return
	 */
	public int mostrarMensaje() {
        panel.add(this.opcion1);
        panel.add(this.opcion2);
        return JOptionPane.showConfirmDialog(panel, this.getDescripcionVentana(), this.getTitulo(), 0);
	}
}
