package com.techlab.articulo.menu;

import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;

public class MenuCategorias extends Menu {

    private final Repositorio<Articulo> repoArticulos;

    public MenuCategorias(Scanner teclado, Repositorio<Articulo> repoArticulos) {
        super(teclado);
        this.repoArticulos = repoArticulos;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ CATEGORÍAS ---");
        System.out.println("1 - Listar categorías");
        System.out.println("2 - Buscar categoría por código");
        System.out.println("3 - Ver artículos de una categoría");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción");
            switch (opcion) {
                case 1 -> listarCategorias();
                case 2 -> buscarCategoria();
                case 3 -> verArticulosPorCategoria();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }
            if (opcion != 0) pausar();
        } while (opcion != 0);
    }

    private void listarCategorias() {
        System.out.println("\nCategorías predefinidas:");
        for (Categoria c : Categoria.values()) {
            System.out.println(c.getCodigo() + " - " + c.getNombre() + "\t |   " + c.getDescripcion());
        }
    }

    private void buscarCategoria() {
        int cod = leerEntero("Código categoría");
        try {
            Categoria c = Categoria.buscarPorCodigo(cod);
            System.out.println("Encontrada: " + c.getNombre() + " - " + c.getDescripcion());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void verArticulosPorCategoria() {
        listarCategorias();
        int cod = leerEntero("Código categoría");
        try {
            Categoria cat = Categoria.buscarPorCodigo(cod);
            System.out.println("\nArtículos en " + cat.getNombre() + ":");
            repoArticulos.listar().stream()
                .filter(a -> a.getCategoria() == cat)
                .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Categoría inválida");
        }
    }
}