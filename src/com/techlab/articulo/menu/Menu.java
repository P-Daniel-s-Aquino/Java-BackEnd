package com.techlab.articulo.menu;

import java.util.Scanner;

public abstract class Menu {

    protected Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void mostrarMenu();

    public abstract void ejecutar();


    protected int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Ingrese un número entero.");
            }
        }
    }

    protected double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String input = scanner.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Ingrese un número decimal.");
            }
        }
    }

    protected String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine().trim();
    }

    protected boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("s") || input.equals("si")) {
                return true;
            }
            if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Responda con s o n.");
        }
    }

    protected void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}