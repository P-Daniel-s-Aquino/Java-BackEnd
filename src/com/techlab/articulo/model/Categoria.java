package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;

public enum Categoria implements Identificable {
    ELECTRONICA(1, "Electrónica", "Productos tecnológicos y electrónicos"),
    PERIFERICOS(2, "Periféricos", "Accesorios para computadora"),
    ALIMENTOS(3, "Alimentos", "Productos alimenticios"),
    CONGELADOS(4, "Congelados", "Productos alimenticios congelados");

    private final int codigo;
    private final String nombre;
    private final String descripcion;

    Categoria(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Categoria buscarPorCodigo(int codigo) {
        for (Categoria c : values()) {
            if (c.codigo == codigo) return c;
        }
        throw new IllegalArgumentException("Código de categoría inválido: " + codigo);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}