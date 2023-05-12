/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class ValidarExpresiones {
    public static void main(String[] args) {
        System.out.println(validarNombre("Pablo Velez Fernandez 99"));
    }
    
    public static boolean validarNombre(String s){
        return s.matches("([A-Z][a-z]+ {0,1})+([1-9]{1,2}-|S/N)");
    }
}
