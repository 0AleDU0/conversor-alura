package conversor.modelo;
/**
 * requisitos que debe tener un conversor
 * @author Alex M.
 *
 */
public interface Conversor {
	/**
	 * 
	 * @param datos -> valor a convertir numerico Double
	 * @param tipoConversion -> conversion especifica que se usara
	 * 		ej: usd convertir a euros
	 * @param tipoConversor -> conversor general que se usara
	 * 		ej: monedas, temperatura, distancias...
	 * @return
	 */
	public String convertir(Double datos, String tipoConversion, String tipoConversor);
	
	/**
	 * 
	 * @param moneda -> valor introducido a convertir:
	 * ej: 6.08
	 * @param tipoConversion -> valor String de que divisa a que divisa se convertira
	 * ej: Dolar estadounidense convertir a pesos meicanos
	 * @return
	 */
	public Double convertirMoneda(Double moneda, String datoBase, String datoConvertir);
	
	/**
	 * 
	 * @param temperatura -> valor introducido a convertir:
	 * ej: 6.08
	 * @param tipoConversion -> valor String de que temperatura a cual se convertira
	 * ej: celcicus convertir a farenheit
	 * @return
	 */
	public Double convertirTemperatura(Double temperatura, String datoBase, String datoConvertir);
	
}
