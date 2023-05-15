
import java.util.Scanner;


/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class ConteoPalabras {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String op;
        
        do {
            System.out.println("Ingrese una cadena de texto: ");
            String cad = s.nextLine();
            while (!validarCadena(cad)) {
                System.out.print("Ingrese solo cadenas con espacios o puntos: ");
                cad = s.nextLine();
            }

            contarCadenas(cad);

            System.out.print("\nDESEA CONTINUAR S/N\nDigite su opcion: ");
            op = s.nextLine();
            while (!op.matches("s|S|n|N")) {
                System.out.print("ERROR! Ingrese s/n: ");
                op = s.nextLine();
            }

        } while (!op.matches("n|N"));
    }
    
    public static boolean validarCadena(String s){
        return s.matches("([a-zA-Z]+(\\.|,){0,1} {0,1})+");
    }
    
    public static void contarCadenas(String s){
        String cad = s.replaceAll("\\.|,", "");
        cad = cad.toLowerCase();
        
        String cadenas[] = cad.split(" ");
        
        ordenamientoCadenas(cadenas);
        ordenarSegunLongitud(cadenas);
        
        String[] cadUnicos = eliminarDuplicados(cadenas);
        int[] contCadenas = new int [cadUnicos.length];
        
        for (int i = 0; i < cadUnicos.length; i++) {
            for (int j = 0; j < cadenas.length; j++) {
                if(cadenas[j].equals(cadUnicos[i])){
                    contCadenas[i]++;
                }
            }
        }
        int numChar = cadUnicos[0].length();
        int contCad = 0;
        for (int i=0;i<cadUnicos.length;i++) {
            if(cadUnicos[i].length()>numChar){
                System.out.printf("%-30s %d\n","Palabras de "+numChar+" letras",contCad);
                numChar = cadUnicos[i].length();
                contCad = 0;
            }
            contCad+=contCadenas[i];
            System.out.printf("%-30s %d\n",cadUnicos[i],contCadenas[i]);  
        }
        System.out.printf("%-30s %d\n","Palabras de "+numChar+" letras",contCad);
    }
    
    public static String[] eliminarDuplicados(String[] array) {
        int n = array.length;
        int numElementosUnicos = 0;
        
       
        
        for (int i = 0; i < n; i++) {
            boolean esUnico = true;
            for (int j = 0; j < i; j++) {
                if (array[i].equals(array[j])) {
                    esUnico = false;
                    break;
                }
            }
            if (esUnico) {
                numElementosUnicos++;
            }
        }

        String[] arraySinDuplicados = new String[numElementosUnicos];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean esUnico = true;
            for (int j = 0; j < i; j++) {
                if (array[i].equals(array[j])) {
                    esUnico = false;
                    break;
                }
            }
            if (esUnico) {
                arraySinDuplicados[index] = array[i];
                index++;
            }
        }

        return arraySinDuplicados;
    }
    
    public static void ordenamientoCadenas(String[] array) {
        int n = array.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Intercambiar elementos
                    String aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    intercambio = true;
                }
            }

            if (!intercambio) {
                break;
            }
        }
    }
    
    public static void ordenarSegunLongitud(String []cadenas){
        for (int i = 0; i < cadenas.length - 1; i++) {
            for (int j = 0; j < cadenas.length - i - 1; j++) {
                if (cadenas[j].length() > cadenas[j + 1].length()) {
                    String aux = cadenas[j];
                    cadenas[j] = cadenas[j + 1];
                    cadenas[j + 1] = aux;
                }
            }
        }
    }
}
