package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Calculable;
import com.techlab.articulo.interfaces.Identificable;

public abstract class Articulo implements Calculable, Identificable {
    private static int contador = 0;
    protected final int codigo;
    protected String nombre;
    protected double precio;
    protected Categoria categoria;

    protected Articulo(){
    }

    protected Articulo(String nombre, double precio, Categoria categoria) {
        this.codigo = ++contador;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Articulo.contador = contador;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract String getTipoArticulo();

    @Override
    public abstract double calcularPrecioFinal();
    
    @Override
    public abstract int getCodigo();

    @Override
    public String toString() {
        return (
            "Codigo: " + this.codigo +
            "Nombre: " + this.nombre +
            "Precio: " + this.precio +
            "Categoria: " + this.categoria +
        );
    }
}
