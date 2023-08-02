package conversor.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * superclase de las ventanas
 * @author Alex M.
 *
 */
public abstract class VentanaConversor {
	private String titulo;
	private String descripcionVentana;
	private Integer icono;
	private List<String> listaOpciones = new ArrayList<>();
	
	public VentanaConversor(String titulo, String descripcionVentana, Integer icono) {
		this.titulo = titulo;
		this.descripcionVentana = descripcionVentana;
		this.icono = icono;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getDescripcionVentana() {
		return descripcionVentana;
	}
	
	public int getIcono() {
		return icono;
	}
	
	/**
	 * metodo que arregla varios parametros en uno a listaOpciones
	 * @param datosDeConversion 
	 * @param valores
	 */
	public void addlista(List<String> datosDeConversion, String... valores) {
	    this.listaOpciones.addAll(Arrays.asList(valores));
	}
	/**
	 * recibe valores String para agregarlos a un ArrrayList de Strings 
	 * @param valores
	 */
	public void addlista(String... valores) {
	    this.listaOpciones.addAll(Arrays.asList(valores));
	}
	
	public List<String> getListaOpciones() {
		return listaOpciones;
	}
	
}
