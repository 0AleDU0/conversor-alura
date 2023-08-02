package conversor.modelo;

public enum ValoresDivisas {
	/**
	 * valores expresados en moneda vase de dolar
	 *  ej: 1 dolar es igual a 6.90 Bolivianos en moneda boliviana
	 *  @author AlexM
	 *  fecha tomada de divisas del 29 de julio del 2023 
	 */
    DOLAR(1.0), BOLIVIANO(6.90), LIBRA_ESTERLINA(0.78), EURO(0.91),PESO_MEXICANO(16.69),
    YEN_JAPONES(141.15), REAL_BRASILEÑO(4.73), WON_SURCOREANO(12073.38);
	
    private double divisa;

    private ValoresDivisas(double valor) {
        this.divisa = valor;
    }
    
    public double getValorDivisa() {
        return divisa;
    }
	
}
