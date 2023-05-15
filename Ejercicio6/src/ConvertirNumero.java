
/**
 *
 * @author RodrigoOrtiz y Pablo Velez
 */
public class ConvertirNumero {

    public static void main(String[] args) {
        System.out.println(validarNum("9999999999.01"));
        System.out.println(convertirNumeroALetras(999.99));
    }

    public static boolean validarNum(String s) {
        return s.matches("[1-9][0-9]{0,9}(.[0-9][1-9]{0,1}){0,1}");
    }

    static final String[] unidades = {
        "", "UN ", "DOS ", "TRES ", "CUATRO ",
        "CINCO ", "SEIS ", "SIETE ", "OCHO ",
        "NUEVE ", "DIEZ ", "ONCE ", "DOCE ",
        "TRECE ", "CATORCE ", "QUINCE ", "DIECISÉIS ",
        "DIECISIETE ", "DIECIOCHO ", "DIECINUEVE ", "VEINTE "
    };

    static final String[] decenas = {
        "VEINTI", "TREINTA ", "CUARENTA ",
        "CINCUENTA ", "SESENTA ", "SETENTA ",
        "OCHENTA ", "NOVENTA "
    };

    static final String[] centenas = {
        "", "CIENTO ", "DOSCIENTOS ",
        "TRESCIENTOS ", "CUATROCIENTOS ",
        "QUINIENTOS ", "SEISCIENTOS ",
        "SETECIENTOS ", "OCHOCIENTOS ",
        "NOVECIENTOS "
    };

    public static String convertirNumeroALetras(double numero) {
        long entero = (long) numero;
        int decimales = (int) ((numero - entero) * 100);

        String numeroEnLetras = "";

        if (entero >= 0 && entero <= 9999999999L) {
            if (entero == 0) {
                numeroEnLetras = "CERO ";
            } else if (entero < 0) {
                numeroEnLetras = "MENOS " + convertirParteEntera(-entero);
            } else {
                numeroEnLetras = convertirParteEntera(entero);
            }

            numeroEnLetras += "CON " + convertirParteDecimal(decimales);
        } else {
            numeroEnLetras = "Número fuera de rango";
        }

        return numeroEnLetras.trim();
    }

    private static String convertirParteEntera(long numero) {
        if (numero <= 20) {
            return unidades[(int) numero];
        } else if (numero < 100) {
            int unidad = (int) (numero % 10);
            int decena = (int) (numero / 10);
            return decenas[decena] + unidades[unidad];
        } else if (numero < 1000) {
            int unidad = (int) (numero % 10);
            int centena = (int) (numero / 100);
            int decena = (int) ((numero % 100) / 10);
            int unidadDecena = (int) (numero % 100);

            if (unidadDecena <= 20) {
                return centenas[centena] + unidades[unidadDecena];
            } else {
                return centenas[centena] + decenas[decena] + unidades[unidad];
            }
        } else {
            return "Número fuera de rango";
        }
    }

    private static String convertirParteDecimal(int numero) {
        if (numero == 0) {
            return "";
        } else if (numero <= 20) {
            return unidades[numero];
        } else {
            int unidad = numero % 10;
            int decena = numero / 10;
            return decenas[decena] + unidades[unidad];
        }
    }
}
