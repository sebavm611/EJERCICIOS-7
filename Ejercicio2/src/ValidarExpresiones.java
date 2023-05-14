
import java.util.Scanner;
/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class ValidarExpresiones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opc;
        
        do{
            System.out.print("Ingrese la cadena a ser validada: ");
            String cad = sc.nextLine();
            System.out.println("[1]Validar nombre");
            System.out.println("[2]Validar direccion");
            System.out.println("[3]Validar contraseña");
            System.out.print("Elija una opcion: ");
            int opcMnu = sc.nextInt();
            
            switch (opcMnu) {
                case 1:
                    if(validarNombre(cad))
                        System.out.println("El nombre es valido");
                    else
                        System.out.println("El nombre es invalido. Debe agregar como minimo el nombre y apellido separado por espacios");
                    break;
                case 2:
                    if(validarDireccion(cad))
                        System.out.println("La direccion es valida");
                    else
                        System.out.println("La direccion debe incluir un numero, si no tiene debe incluir S/N. Puede tener una calle secundaria");
                    break;
                case 3:
                    if(validarContrasenia(cad))
                        System.out.println("La contraseña es valida");
                    else
                        System.out.println("La contraseña debe contener 2 digitos, 2 mayusculas y 2 minusculas. Debe contener de 8 a 11 caracteres");
                    break;
                default:
                    System.out.println("ERROR! Ingrese una opcion correcta");
            }
            
            sc.nextLine();
            System.out.print("Desea continuar? (S/n): ");
            opc = sc.nextLine();
            while (!opc.matches("s|S|n|N")) {
                System.out.print("ERROR! Ingrese (S/N): ");
                opc = sc.nextLine();
            }
            System.out.println("");
  
            
        }while(!opc.matches("n|N"));
        
    }
    
    public static boolean validarDireccion(String s){
        return s.matches("([A-Z][a-z]+ )+([1-9]{1,2}-(1[1-2][0-9]|[1-9][0-9]|[1-9]|130)|(S/N))( y ([A-Z][a-z]+ {0,1})+){0,1}");
    }
    
    public static boolean validarNombre(String s){
        return s.matches("[A-Z][a-z]+( [A-Z][a-z]+){1,3}");
    }
    
    public static boolean validarContrasenia(String s){
        return s.matches("^(?=.*\\d.*\\d)(?=.*[a-z].*[a-z])(?=.*[A-Z].*[A-Z]).{8,11}$");
    }
}
