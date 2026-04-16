package clasesTalentoTech;

import java.util.Scanner;

public class Clase3 {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese su edad");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Escriba su nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Su edad es: " +edad+ " y su nombre es: " +nombre);
        

        teclado.close();
    }
}
