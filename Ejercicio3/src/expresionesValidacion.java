/*
 3. Realizar las siguientes validaciones utilizando expresiones regulares.
Dirección IPv4
Correo electrónico
Dirección URL

"^(\\d{1,3}\\.){3}\\d{1,3}$"

 * @author Pablo Vélez y Rodrigo Ortiz  MARZO - JULIO 2023
 */

import java.util.Scanner;

public class expresionesValidacion {

    public static int leerOpcion(String m, int min, int max) {

        int op;

        Scanner s = new Scanner(System.in);

        System.out.print(m);

        op = s.nextInt();

        while (op < min || op > max) {

            System.out.print("ERROR! Ingrese un numero entre " + min + " y " + max + ": ");

            op = s.nextInt();
        }

        return op;
    }

    public static void leerDireccionIPv4() {

        String direccion;

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese la direccion IPv4: ");

        direccion = s.nextLine();

        while (!direccion.matches("^([0-1]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([0-1]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([0-1]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([0-1]?\\d\\d?|2[0-4]\\d|25[0-5])$")) {

            System.out.print("ERROR La direccion no puede tener espacios, ademas debe contener 4 bloques de numeros de hasta 3 digitos entre 0-255 y separados por un punto: ");

            direccion = s.nextLine();

        }

        System.out.print("\nLA DIRECCION IPv4 INGRESADA ES VALIDA!\n");
    }

    public static void leerCorreo(){
        
        String correo;
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Ingrese el correo electronico: ");
        
        correo = s.nextLine();
        
        while(!correo.matches("^[^\\.][a-zA-Z0-9.]+[^\\.]@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")){
            
            System.out.print("\nERROR! El correo ingresado es invalido\nDebe seguir la siguiente estructura:\n\nNombre de usuario(iniciar y terminar en una letra o numero) + símbolo @ + nombre de dominio + caracter \".\" + extensión de dominio (compuesto por mas de una letra) y no tener espacios ni caracteres especiales a excepcion de puntos\nIngrese nuevamente: ");
            
            correo = s.nextLine();
        }
        
        System.out.print("\nEL CORREO INGRESADO ES VALIDO!\n");
    }
    
    public static void leerURL(){
        
        String URL;
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Ingrese la URL: ");
        
        URL = s.nextLine();
        
        while(!URL.matches("^(http://|https://)(www\\.)?[A-Za-z0-9]+([\\.-_][A-Za-z0-9]+)*\\.(com|net|ec|es)/?([A-Za-z0-9]+(/[A-Za-z0-9]+)*)?(\\?[A-Za-z0-9]+=[A-Za-z0-9]+(&[A-Za-z0-9]+=[A-Za-z0-9]+)*)?$")){
            
            System.out.print("\nERROR! La URL ingresada es invalida\nDebe seguir la siguiente estructura\n\nEsquema + autoridad (que incluye el nombre de dominio (posibles subdominios) y el puerto) + una ruta + un conjunto de parámetros de consulta y un fragmento\nIngrese nuevamente: ");
            
            URL = s.nextLine();
           
        }
        
        System.out.print("\nLA URL INGRESADA ES VALIDA!\n");
    }
    
    public static void main(String[] args) {

        int op;

        do {

            op = leerOpcion("-----MENU-----\n1.Direccion IPv4\n2.Correo electronico\n3.Direccion URL\n4.Salir\nDigite su opcion: ", 1, 4);

            switch (op) {

                case 1:

                    leerDireccionIPv4();

                    break;
                case 2:

                    leerCorreo();
                    
                    break;
                case 3:

                    leerURL();
                    
                    break;
            }

            System.out.println();
            
        } while (op != 4);

    }

}
