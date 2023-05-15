/*
 6. Realizar un programa que permita convertir una cantidad ingresada en números (en el rango 0 a
9999999999.99) a letras.

 * @author Pablo Vélez y Rodrigo Ortiz  MARZO - JULIO 2023
 */
import java.util.Scanner;

public class numeroaLetra {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String numero;

        double numeroDecimal;

        do {
            System.out.print("Ingrese un número entre 0 y 9999999999.99: ");

            numero = scanner.nextLine();

            try {

                numeroDecimal = Double.parseDouble(numero);

                if (numeroDecimal < 0 || numeroDecimal > 9999999999.99) {

                    System.out.println("El número ingresado está fuera de rango.");

                    continue;
                }
                numeroDecimal = Math.round(numeroDecimal * 100.0) / 100.0;

                break;

            } catch (NumberFormatException e) {

                System.out.println("El número ingresado no es válido.");

            }
        } while (true);

        int numeroEntero = (int) numeroDecimal;

        int numeroDecimalEntero = (int) Math.round((numeroDecimal - numeroEntero) * 100);

        String numeroEnLetras = convertirNumeroALetras(numeroEntero);

        if (numeroDecimalEntero > 0) {

            numeroEnLetras += " coma " + convertirNumeroALetras(numeroDecimalEntero);
        }

        System.out.println(numero + " en letras: " + numeroEnLetras);
    }

    private static final String[] unidades = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

    private static final String[] especiales = {"once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};

    private static final String[] decenas = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

    private static final String[] centenas = {"cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};

    private static final String[] miles = {"", "mil", "millón", "mil millones", "billón", "mil billones", "trillón", "mil trillones", "cuatrillón", "mil cuatrillones", "quintillón", "mil quintillones", "sextillón", "mil sextillones", "septillón", "mil septillones", "octillón", "mil octillones", "nonillón", "mil nonillones", "decillón", "mil decillones"};

    public static String convertirNumeroALetras(int numero) {

        if (numero < 0) {

            return "menos " + convertirNumeroALetras(-numero);

        } else if (numero < 10) {

            return unidades[numero];

        } else if (numero < 20) {

            return especiales[numero - 11];

        } else if (numero < 100) {

            int decena = numero / 10;

            int unidad = numero % 10;

            if (unidad == 0) {

                return decenas[decena - 1];

            } else {

                return decenas[decena - 1] + " y " + unidades[unidad];
            }

        } else if (numero < 200) {

            int unidad = numero % 100;

            if (unidad == 0) {

                return "cien";

            } else {

                return "ciento " + convertirNumeroALetras(unidad);
            }

        } else if (numero < 1000) {

            int centena = numero / 100;

            int resto = numero % 100;

            if (resto == 0) {

                return centenas[centena - 1];

            } else {

                return centenas[centena - 1] + " " + convertirNumeroALetras(resto);
            }

        } else {

            int contador = 0;

            String palabras = "";

            while (numero > 0) {

                int fragmento = numero % 1000;

                if (fragmento != 0) {

                    String palabrasFragmento = convertirNumeroALetras(fragmento);

                    if (contador == 0) {

                        palabras = palabrasFragmento;

                    } else if (contador == 1) {

                        if (fragmento == 1) {

                            palabras = "mil " + palabras;

                        } else {

                            palabras = palabrasFragmento + " " + miles[contador] + " " + palabras;
                        }
                    } else {

                        if (fragmento == 1) {

                            palabras = "un " + miles[contador] + " " + palabras;
                        } else {
                            palabras = palabrasFragmento + " " + miles[contador] + " " + palabras;
                        }
                    }
                }
                contador++;

                numero /= 1000;
            }
            return palabras;
        }
    }
}
