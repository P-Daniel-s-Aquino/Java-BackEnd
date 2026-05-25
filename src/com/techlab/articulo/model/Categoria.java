package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;
import java.util.ArrayList;
import java.util.List;


public enum Categoria implements Identificable {
    ELECTRONICA(1, "Electrónica", "Productos tecnológicos y electrónicos", TipoArticulo.ELECTRONICO),
    PERIFERICOS(2, "Periféricos", "Accesorios para computadora", TipoArticulo.ELECTRONICO),
    ALIMENTOS(3, "Alimentos", "Productos alimenticios", TipoArticulo.ALIMENTICIO),
    CONGELADOS(4, "Congelados", "Productos alimenticios congelados", TipoArticulo.ALIMENTICIO);

    private final int codigo;
    private final String nombre;
    private final String descripcion;
    private final TipoArticulo tipo;

    Categoria(int codigo, String nombre, String descripcion, TipoArticulo tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
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

    public TipoArticulo getTipo() {
        return tipo;
    }

    public static Categoria buscarPorCodigo(int codigo) {
        for (Categoria c : values()) {
            if (c.codigo == codigo) return c;
        }
        throw new IllegalArgumentException("Código de categoría inválido: " + codigo);
    }

    public static List<Categoria> listarPorTipo(TipoArticulo tipo) {
        List<Categoria> resultado = new ArrayList<>();
        for (Categoria c : values()) {
            if (c.getTipo() == tipo) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}