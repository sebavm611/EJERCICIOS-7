
import java.util.Scanner;
/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class NumerosPerfectos {

    public static void main(String[] args) {

        String op;

        Scanner s = new Scanner(System.in);

        do {

            System.out.print("Ingrese los numeros: ");

            String cadena = s.nextLine();

            while (!numeroEsValido(cadena)) {
                System.out.print("ERROR! La cadena debe tener solo numeros enteros separados por un espacio: ");
                cadena = s.nextLine();
            }

            imprimirPerfectos(cadena);

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

    public static void imprimirPerfectos(String s) {
        String cadenas[] = s.split(" ");
        int enteros[] = new int[cadenas.length];
        String divisores[] = new String[cadenas.length];
        char perfectos[] = new char[cadenas.length];

        for (int i = 0; i < cadenas.length; i++) {
            enteros[i] = Integer.parseInt(cadenas[i]);
        }

        for (int j = 0; j < enteros.length; j++) {
            String cad = "";
            int suma = 0;
            //System.out.print("Divisores de: "+enteros[j]": ");
            for (int i = 1; i < enteros[j]; i++) {
                if (enteros[j] % i == 0) {
                    suma += i;
                    if (i == 1) {
                        cad = cad.concat(String.valueOf(i));
                        //System.out.print(i);
                    } else {
                        cad = cad.concat("+" + String.valueOf(i));
                        //System.out.print("+"+i);
                    }
                }
            }
            if (suma == enteros[j]) {
                perfectos[j] = 'X';
            }

            divisores[j] = cad;
        }

        System.out.println("NUMEROS\tPERFECTO  COMPROBACION");
        for (int i = 0; i < enteros.length; i++) {
            System.out.print(enteros[i] + "\t" + perfectos[i] + "\t  ");
            if (perfectos[i] == 'X') {
                System.out.print(divisores[i]);
            }
            System.out.println("");
        }
    }
}

