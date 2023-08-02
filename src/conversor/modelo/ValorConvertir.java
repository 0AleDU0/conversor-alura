package conversor.modelo;

import java.util.ArrayList;
import java.util.List;

public class ValorConvertir extends VentanaConversor {
	
	public ValorConvertir(String titulo, String descripcionVentana, Integer icono) {
		super(titulo, descripcionVentana, icono);
	}
	/**
	 * realiza un retorno de valores de List mezclados 3 veces un valor(valores base) a otras restantes del la misma List
	 * ej: ["A", "B", "C", "D","E"] -> tomamos los primeros ["A", "B", "C"] -> como valores base y los mezclamos con los restantes sin 
	 * repetir "A" convertir a "A" (evita esas incongruencias)
	 */
	@Override
	public List<String> getListaOpciones() {
		List<String> opciones = new ArrayList<String>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < super.getListaOpciones().size(); j++) {
				if (i == j) {
					continue;
				}
				opciones.add(super.getListaOpciones().get(i) + " convertir a " + super.getListaOpciones().get(j));
			}
		}
		
		return opciones;
	}
	
}
