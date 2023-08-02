package conversor.modelo;
/**
 * class que contiene los metodos de convercion de temperatura
 * @author Alex M.
 *
 */
public abstract class ConversorTemperaturas {
	
	/**
	 * retorna valor en celcius para ser tratado por sus otros metodos en sus respectivos metodos
	 * @param valorTemperatura
	 * @param datoBase
	 * @param datoConvertir
	 * @return
	 */
	static public Double convertirTemperatura(Double valorTemperatura,  String datoBase, String datoConvertir) { 
		Double valorCelcius = 0.0;
		switch (datoBase) {
		case "KELVIN":
			valorCelcius = valorTemperatura - 273.15;
			break;
		case "FARENHEIT":
			valorCelcius = (valorTemperatura - 32.0) * (5.0/9.0);
		}
		
		switch (datoConvertir) {
		case "KELVIN":
			return convertTokelvin(valorCelcius);
		case "FARENHEIT":
			return convertToFarenheit(valorCelcius);
		case "RANKINE":
			return convertToRankine(valorCelcius);
		case "REAUMUR":
			return convertToReaumur(valorCelcius);
		default:
			return valorCelcius;
		}
	}
	/**
	 * convierte celcius a farenheit
	 * @param valorCelcius
	 * @return
	 */
	static public Double convertToFarenheit(Double valorCelcius) {
		return (valorCelcius * 9.0/5.0) + 32.0;
	}
	/**
	 * convierte celcius a kelvin
	 * @param valorCelcius
	 * @return
	 */
	static public Double convertTokelvin(Double valorCelcius) {
		return valorCelcius + 273.15;
	}
	/**
	 * convierte celcius a rankine
	 * @param valorCelcius
	 * @return
	 */
	static public Double convertToRankine(Double valorCelcius) {
		return (valorCelcius + 273.15) * (9.0/5.0);
	}
	/**
	 * convierte celcius a reaumur
	 * @param valorCelcius
	 * @return
	 */
	static public Double convertToReaumur(Double valorCelcius) {
		return valorCelcius * 4.0/5.0;
	}
	
}

