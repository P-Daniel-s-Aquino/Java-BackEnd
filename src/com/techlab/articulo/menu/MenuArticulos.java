package com.techlab.articulo.menu;

import java.util.List;
import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.ArticuloAlimenticio;
import com.techlab.articulo.model.ArticuloElectronico;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Validaciones;

public class MenuArticulos extends Menu {

    private final Repositorio<Articulo> repoArticulos;

    public MenuArticulos(Scanner teclado, Repositorio<Articulo> repoArticulos) {
        super(teclado);
        this.repoArticulos = repoArticulos;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ ARTÍCULOS ---");
        System.out.println("1 - Agregar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Buscar por código");
        System.out.println("4 - Modificar artículo");
        System.out.println("5 - Eliminar artículo");
        System.out.println("6 - Listar por categoría");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción");
            switch (opcion) {
                case 1 -> agregarArticulo();
                case 2 -> listarArticulos();
                case 3 -> buscarArticuloPorCodigo();
                case 4 -> modificarArticulo();
                case 5 -> eliminarArticulo();
                case 6 -> listarArticulosPorCategoria();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }
            if (opcion != 0) pausar();
        } while (opcion != 0);
    }

    private void agregarArticulo() {
        System.out.println("\nTipo: 1-Electrónico  2-Alimenticio");
        int tipo = leerEntero("Tipo");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido");
            return;
        }

        String nombre = leerTexto("Nombre");
        while (!Validaciones.validarTextoNoVacio(nombre) || !Validaciones.validarLongitudMaxima(nombre, 50)) {
            System.out.println("Nombre inválido (1-50 caracteres)");
            nombre = leerTexto("Nombre");
        }

        double precio = leerDouble("Precio");
        while (!Validaciones.validarNoNegativo(precio)) {
            System.out.println("Precio no puede ser negativo");
            precio = leerDouble("Precio");
        }

        System.out.println("Categorías disponibles:");
        for (Categoria c : Categoria.values()) {
            System.out.println(c.getCodigo() + " - " + c.getNombre());
        }
        int codCat = leerEntero("Código categoría");
        Categoria categoria;
        try {
            categoria = Categoria.buscarPorCodigo(codCat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        Articulo nuevo;
        if (tipo == 1) {
            int garantia = leerEntero("Garantía en meses");
            while (!Validaciones.validarNoNegativo(garantia)) {
                System.out.println("Valor inválido");
                garantia = leerEntero("Garantía en meses");
            }
            nuevo = new ArticuloElectronico(garantia, nombre, precio, categoria);
        } else {
            int dias = leerEntero("Días para vencimiento");
            while (!Validaciones.validarNoNegativo(dias)) {
                System.out.println("Valor inválido");
                dias = leerEntero("Días para vencimiento");
            }
            nuevo = new ArticuloAlimenticio(dias, nombre, precio, categoria);
        }

        repoArticulos.agregar(nuevo);
        System.out.println("Artículo agregado con código: " + nuevo.getCodigo());
    }

    private void listarArticulos() {
        List<Articulo> lista = repoArticulos.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay artículos");
            return;
        }
        lista.forEach(System.out::println); // for (Articulo a : lista) System.out.println(a);
    }

    private void buscarArticuloPorCodigo() {
        int codigo = leerEntero("Código a buscar");
        Articulo articulo = repoArticulos.buscarPorCodigo(codigo);
        if (articulo == null) {
            System.out.println("No encontrado");
        } else {
            System.out.println(articulo);
            System.out.println("Precio final: $" + String.format("%.2f", articulo.calcularPrecioFinal()));
        }
    }

    private void modificarArticulo() {
        int codigo = leerEntero("Código a modificar");
        Articulo articulo = repoArticulos.buscarPorCodigo(codigo);
        if (articulo == null) {
            System.out.println("No encontrado");
            return;
        }
        System.out.println("Actual: " + articulo);

        if (leerSiNo("¿Cambiar nombre?")) {
            String nuevoNombre = leerTexto("Nuevo nombre");
            if (Validaciones.validarTextoNoVacio(nuevoNombre)) articulo.setNombre(nuevoNombre);
        }
        if (leerSiNo("¿Cambiar precio?")) {
            double nuevoPrecio = leerDouble("Nuevo precio");
            if (Validaciones.validarNoNegativo(nuevoPrecio)) articulo.setPrecio(nuevoPrecio);
        }
        if (leerSiNo("¿Cambiar categoría?")) {
            for (Categoria categoria : Categoria.values()) System.out.println(categoria);
                int codigoCategoria = leerEntero("Nuevo código categoría");
            try { articulo.setCategoria(Categoria.buscarPorCodigo(codigoCategoria)); } 
            catch (Exception e) { System.out.println("Categoría inválida, se mantiene"); }
        }

        if (articulo instanceof ArticuloElectronico ae && leerSiNo("¿Cambiar garantía?")) {
            int nuevaGarantia = leerEntero("Nueva garantía");
            if (Validaciones.validarNoNegativo(nuevaGarantia)) ae.setGarantiaMeses(nuevaGarantia);
        }
        if (articulo instanceof ArticuloAlimenticio aa && leerSiNo("¿Cambiar días vencimiento?")) {
            int nuevoDia = leerEntero("Nuevos días");
            if (Validaciones.validarNoNegativo(nuevoDia)) aa.setDiasParaVencimiento(nuevoDia);
        }
        System.out.println("Modificado: " + articulo);
    }

    private void eliminarArticulo() {
        int codigo = leerEntero("Código a eliminar");
        boolean ok = repoArticulos.eliminarPorCodigo(codigo);
        System.out.println(ok ? "Eliminado" : "No encontrado");
    }

    private void listarArticulosPorCategoria() {
        for (Categoria categoria : Categoria.values()) {
            System.out.println(categoria);
        }
        
        int codigoCategoria = leerEntero("Código categoría");
        
        try {
            Categoria cat = Categoria.buscarPorCodigo(codigoCategoria);
            
            for (Articulo articulo : repoArticulos.listar()) {
                if (articulo.getCategoria() == cat) {
                    System.out.println(articulo);
                }
            }
        } catch (Exception e) {
            System.out.println("Categoría inválida");
        }
    }
}