package conversor.test;

import javax.swing.JOptionPane;
import conversor.modelo.*;

public class Main {
	public static void main(String[] args) {
		
		while (true) {
			// menu principal
			VentanaNormal menuP = new VentanaNormal("Menu", "Seleccione una opción de conversion", JOptionPane.QUESTION_MESSAGE);
			// la ultima palabra de addlista deve ser el el tipo de conversion seleccionado
			menuP.addlista("Conversor de moneda", "Conversor de temperatura");
			String tipoConversor = (String)JOptionPane.showInputDialog(null, menuP.getDescripcionVentana(), menuP.getTitulo(),
					menuP.getIcono(), null, menuP.getListaOpciones().toArray(), menuP.getListaOpciones().get(0));
			System.out.println("Conversor seleccionado: " + tipoConversor);
			
			// entrada valor
			String conversorElejido = tipoConversor.substring(tipoConversor.lastIndexOf(" ") + 1);
			String valorTransformar = JOptionPane.showInputDialog(null, "Ingrese la cantidad de " + conversorElejido + " a convertir:",
			        				tipoConversor, JOptionPane.PLAIN_MESSAGE);
			System.out.println("Valor seleccionado a convertir: " + valorTransformar);
			
			Boolean inputCorrecto;
			try {
			    Double.parseDouble(valorTransformar);
			    inputCorrecto = true;
			} catch (NumberFormatException e) {
			    JOptionPane.showMessageDialog(null, "Valor no válido", "Error", JOptionPane.ERROR_MESSAGE);
			    inputCorrecto = false;
			}
			
			if (inputCorrecto) {
				// elejimos el valor especifico a convertir
				ValorConvertir OpcionesConvertir = new ValorConvertir(tipoConversor, "Elije el tipo de conversion de " + conversorElejido, null);
				
				switch (tipoConversor) {
				case "Conversor de moneda":
					OpcionesConvertir.addlista("Boliviano","Dolar","Libra esterlina", "Euro", "Peso Mexicano", "Yen japones", "Real brasileño",
										"Won Surcoreano");
					break;
				case "Conversor de temperatura":
					OpcionesConvertir.addlista("Farenheit", "Celsius", "kelvin", "Rankine", "Reaumur");
					break;
				}
				
				String tipoDeConversion = (String)JOptionPane.showInputDialog(null, "Elije el tipo de conversion de " + conversorElejido,
										conversorElejido, JOptionPane.QUESTION_MESSAGE, null, OpcionesConvertir.getListaOpciones().toArray(), 
										OpcionesConvertir.getListaOpciones().get(0));
				System.out.println("valor especifico seleccionado: " + tipoDeConversion);
				
				// conversor
				ValorConvertido valorConvertido = new ValorConvertido("Message", "", JOptionPane.INFORMATION_MESSAGE);
				valorConvertido.listaOpciones = OpcionesConvertir.getListaOpciones();
				String valorFinal = valorConvertido.convertir(Double.parseDouble(valorTransformar), tipoDeConversion, tipoConversor);
				System.out.println(valorFinal);	
				
				// valor de conversion
				JOptionPane.showMessageDialog(null, "Tienes " + valorFinal, valorConvertido.getTitulo(), JOptionPane.INFORMATION_MESSAGE);
			}
			
			// cuadro -- ¿Desea continuar?
			VentanaContinuar deseaContinuar = new VentanaContinuar("¿ Seleccione una opcion","Desea Continuar ?", JOptionPane.INFORMATION_MESSAGE);
			int desicionUsuario = deseaContinuar.mostrarMensaje();
			if (desicionUsuario == 1) {
				break;
			} else {
				continue;
			}
		}
		JOptionPane.showMessageDialog(null, "Programa Terminado.", "Message", JOptionPane.INFORMATION_MESSAGE);
	}
}
