package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;

public enum TipoArticulo implements Identificable {
    ELECTRONICO(1, "Electrónico", "Artículos tecnológicos y electrónicos"),
    ALIMENTICIO(2, "Alimenticio", "Productos comestibles");

    private final int codigo;
    private final String nombre;
    private final String descripcion;

    TipoArticulo(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public static TipoArticulo buscarPorCodigo(int codigo) {
        for (TipoArticulo tipo : values()) {
            if (tipo.codigo == codigo) return tipo;
        }
        throw new IllegalArgumentException("Código de tipo inválido: " + codigo);
    }

    @Override
    public String toString() { return codigo + " - " + nombre; }
}