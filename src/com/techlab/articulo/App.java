package com.techlab.articulo;

import java.util.Scanner;

import com.techlab.articulo.menu.MenuArticulos;
import com.techlab.articulo.menu.MenuCategorias;
import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.repository.Repositorio;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Repositorio<Articulo> repositorioArticulos = new Repositorio<>();

        MenuArticulos menuArticulos = new MenuArticulos(teclado, repositorioArticulos);
        MenuCategorias menuCategorias = new MenuCategorias(teclado, repositorioArticulos);

        int opcion;
        do {
            System.out.println("\n======================================================");
            System.out.println(" SISTEMA DE ARTÍCULOS || E-COMMERCE");
            System.out.println("======================================================");
            System.out.println("1 - Menú de artículos");
            System.out.println("2 - Menú de categorías");
            System.out.println("0 - Salir");
            System.out.println("======================================================");

            opcion = leerEntero(teclado, "Ingrese una opción: ");

            switch (opcion) {
                case 1 -> menuArticulos.ejecutar();
                case 2 -> menuCategorias.ejecutar();
                case 0 -> System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                default -> System.out.println("\nError: opción no válida.");
            }
        } while (opcion != 0);

        teclado.close();
    }

    public static int leerEntero(Scanner teclado, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }
}