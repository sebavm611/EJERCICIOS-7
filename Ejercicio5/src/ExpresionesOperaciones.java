
/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
import java.util.Scanner;

public class ExpresionesOperaciones {

    public static void main(String[] args) {

        String op;

        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Ingrese una cadena de texto que contenga numeros enteros: ");
            String cad = s.nextLine();
            while (!numeroEsValido(cad)) {
                System.out.print("Ingrese solo numeros separados por espacios: ");
                cad = s.nextLine();
            }

            calcularOperaciones(cad);

            System.out.print("DESEA CONTINUAR S/N\nDigite su opcion: ");
            op = s.nextLine();
            while (!op.matches("s|S|n|N")) {
                System.out.print("ERROR! Ingrese s/n: ");
                op = s.nextLine();
            }

        } while (!op.matches("n|N"));

    }

    public static boolean numeroEsValido(String s) {
        return s.matches("([+|-]{0,1}\\d+\\s{0,1})+[+|-]{0,1}[\\d]");
    }

    public static void calcularOperaciones(String s) {
        String cadenas[] = s.split(" ");
        int enteros[] = new int[cadenas.length];

        for (int i = 0; i < cadenas.length; i++) {
            enteros[i] = Integer.parseInt(cadenas[i]);
        }

        int suma = 0;
        for (int entero : enteros) {
            suma += entero;
        }

        double media = (double) suma / enteros.length;
        double sumaDesviacion = 0;
        for (int entero : enteros) {
            double desviacionValor;
            desviacionValor = Math.pow(entero - media, 2);
            sumaDesviacion += desviacionValor;
        }

        double desviacionEstandar = (Math.sqrt(sumaDesviacion / enteros.length));
        double varianzaPoblacional = (double) sumaDesviacion / enteros.length;

        ordenarAreglo(enteros);
        double mediana;
        int tamanio = enteros.length;
        if (tamanio % 2 == 0) {
            mediana = (double) (enteros[tamanio / 2] + enteros[(tamanio / 2) - 1]) / 2;
        } else {
            mediana = enteros[tamanio / 2];
        }
        
        int[] arregloUnicos = eliminarRepetidos(enteros);
        int[] contadorArreglo = new int[arregloUnicos.length];
        
        int cont = 0;
        for (int i = 0; i < arregloUnicos.length; i++) {
            int contAux=0;
            for (int j = 0; j < enteros.length; j++) {
                if(arregloUnicos[i]==enteros[j]){
                    contadorArreglo[i]++;
                    contAux++;
                }
            }
            if(contAux>cont){
                cont = contAux;
            }
        }
        
        StringBuilder moda = new StringBuilder();
        
        for (int i = 0; i < arregloUnicos.length; i++) {
            if(cont==contadorArreglo[i]){
                moda.append(arregloUnicos[i]).append(", ");
            }
        }
        moda.append("con ").append(cont).append(" ocurrencias");
        
        System.out.println("SUMA: " + suma);
        System.out.println("MEDIA: " + media);
        System.out.println("DESVIACION ESTANDAR: " + desviacionEstandar);
        System.out.println("VARIANZA POBLACIONAL: " + varianzaPoblacional);
        System.out.println("MEDIANA: " + mediana);
        System.out.println("MODA: "+moda.toString());
        System.out.println("MAYOR: "+enteros[enteros.length-1]);
        System.out.println("MENOR: "+enteros[0]);
    }

    public static void ordenarAreglo(int array[]) {
        int aux;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
    }
    
    public static int[] eliminarRepetidos(int arreglo[]){
        int longitudOriginal = arreglo.length;

        // Contar el número de elementos únicos
        int contador = 0;
        for (int i = 0; i < longitudOriginal; i++) {
            boolean esRepetido = false;
            for (int j = 0; j < i; j++) {
                if (arreglo[i]==arreglo[j]) {
                    esRepetido = true;
                    break;
                }
            }
            if (!esRepetido) {
                contador++;
            }
        }

        // Crear un nuevo arreglo sin elementos repetidos
        int[] resultado = new int[contador];
        int indice = 0;
        for (int i = 0; i < longitudOriginal; i++) {
            boolean esRepetido = false;
            for (int j = 0; j < i; j++) {
                if (arreglo[i]==arreglo[j]) {
                    esRepetido = true;
                    break;
                }
            }
            if (!esRepetido) {
                resultado[indice] = arreglo[i];
                indice++;
            }
        }

        return resultado;
    }
    
}
