package conversor.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
/**
 * class que enlaza los valores a tipos de conversion mas especificos de divisas, temperaturas...
 * @author Alex M.
 *
 */
public class ValorConvertido extends VentanaConversor implements Conversor {
	
	public ValorConvertido(String titulo, String descripcionVentana, Integer icono) {
		super(titulo, descripcionVentana, icono);
	}

	public List<String> listaOpciones = new ArrayList<>();

	@Override
	public String convertir(Double datos, String tipoConversion, String tipoConversor) {
		String[] tablaConversores =  tipoConversion.split(" convertir a ");
		String datoBase = String.valueOf(tablaConversores[0].replace(" ", "_").toUpperCase());
		String datoConvertir = String.valueOf(tablaConversores[1].replace(" ", "_").toUpperCase());
		System.out.println(datoBase + " -- > " + datoConvertir);
		
		switch (tipoConversor) {
		case "Conversor de moneda":
			return convertirMoneda(datos, datoBase, datoConvertir) + " " +  mensajeSalidaDivisa(datoConvertir.replace("_", " "));
		case "Conversor de temperatura":
			return convertirTemperatura(datos, datoBase, datoConvertir) + " "+ mensajeSalidaTemperatura(datoConvertir.replace("_", " "));
		}
		return null;
	}

	/**
	 * convierte y empareja los valores seleccionados por el usuario con los enums de divisas
	 * para enviar las claves a utilizar en el metodo calcularDivisa()
	 */
	@Override
	public Double convertirMoneda(Double moneda, String datoBase, String datoConvertir) {
		ValoresDivisas divisaBaseEnum = ValoresDivisas.valueOf(datoBase);
		ValoresDivisas divisaConvertirEnum = ValoresDivisas.valueOf(datoConvertir);
		return calcularDivisa(moneda, divisaBaseEnum, divisaConvertirEnum);
	}

	@Override
	public Double convertirTemperatura(Double temperatura, String datoBase, String datoConvertir) {
		return redondearDosDecimales(ConversorTemperaturas.convertirTemperatura(temperatura, datoBase, datoConvertir));
	}	
	/**
	 * convierte la moneda a un estandar usd para calculo mas universal
	 * @param moneda -> valor numerico en Float o Double -> ej: 5.05
	 * @param divisaEntrada -> clave de la divisa en el enum "Valores divisas"
	 * @param divisaSalida -> clave de la divisa en el enum "Valores divisas"
	 * @return
	 */
	private Double calcularDivisa(Double moneda, ValoresDivisas divisaEntrada, ValoresDivisas divisaSalida) { 
		Double monedaToUsD = redondearDosDecimales(moneda / divisaEntrada.getValorDivisa());
		System.out.println("moneda base convertida al dolar: " + monedaToUsD);
		Double valorfinal = monedaToUsD * divisaSalida.getValorDivisa();
		return redondearDosDecimales(valorfinal);
	}
	/**
	 * redondea decimales -> ej: 5.71665115441 redondea a 5.72
	 * @param valor
	 * @return
	 */
    private double redondearDosDecimales(Double valor) {
        BigDecimal redondeo = new BigDecimal(valor);
        redondeo = redondeo.setScale(2, RoundingMode.HALF_UP);
        return redondeo.doubleValue();
    }
    /**
     * muestra mensaje entendible de moneda de Pais 
     * ej : dolar --> dolares
     * @param datoConvertir
     * @return
     */
    public String mensajeSalidaDivisa(String datoConvertir) {
    	String mensajeFinal = null;
    	String[] mensaje = datoConvertir.toLowerCase().split(" ");
    	for (String valor : mensaje) {
    		String comprovador;
    		comprovador = valor.substring(valor.length() - 1);
    		if ("aeiou".contains(comprovador)) {
    			mensajeFinal = valor + "s";
    		} else {
    			mensajeFinal = valor + "es";
    		}	
    	}
    	return mensajeFinal;
    } 
    /**
     * muestra mensaje entendible de temperatura 
     * @param datoConvertir
     * @return
     */
    public String mensajeSalidaTemperatura(String datoConvertir) {
    	return "grados " + datoConvertir.toLowerCase();
    } 
}
