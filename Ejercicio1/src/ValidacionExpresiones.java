
/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
import java.util.Scanner;

public class ValidacionExpresiones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.print("Ingrese la cadena a ser validada: ");
            String cad = sc.nextLine();
            System.out.println("[1]Letras s, S, n, N");
            System.out.println("[2]Numero entero de 3 a 10 digitos, el ultimo digito debe ser diferente de cero");
            System.out.println("[3]Numero entero o real, con o sin signo");
            System.out.print("Elija una opcion: ");
            int opcMnu = sc.nextInt();
            
            System.out.println("");
            switch (opcMnu) {
                case 1:
                    if (validarLetras(cad)) {
                        System.out.println("Validacion correcta");
                    } else {
                        System.out.println("Validacion incorrecta, debe ingresar solamente las letras: s, S, n, N");
                    }
                    break;
                case 2:
                    if(validarDigitos(cad))
                        System.out.println("Validacion correcta");
                    else
                        System.out.println("Validacion incorrecta, debe ingresar un entero de 3 a 10 digitos que no termine en 0");
                    break;
                case 3:
                    if(validarRealEntero(cad))
                        System.out.println("Validacion correcta");
                    else
                        System.out.println("Validacion incorrecta, debe ingresar un numero real o entero con o sin signo");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opcion correcta");
                    
            }
            
            sc.nextLine();
            System.out.print("Desea continuar? (S/n): ");
            opcion = sc.nextLine();
            while (!validarLetras(opcion)) {
                System.out.print("ERROR! Ingrese (S/N): ");
                opcion = sc.nextLine();
            }
            System.out.println("");
        } while (!opcion.matches("n|N"));
    }

    public static boolean validarLetras(String s) {
        return s.matches("s|S|N|n");
    }

    public static boolean validarDigitos(String s) {
        return s.matches("\\d{2,9}([1-9]$)");
    }

    public static boolean validarRealEntero(String s) {
        return s.matches("(\\+|-)?\\d+((,|.)?\\d+)?");
    }
}
