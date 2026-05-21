package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Calculable;
import com.techlab.articulo.interfaces.Identificable;

public abstract class Articulo implements Calculable, Identificable {
    private static int contador = 0;
    
    protected final int codigo;
    protected String nombre;
    protected double precio;
    protected Categoria categoria;

    protected Articulo() {
        this.codigo = ++contador;
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

    @Override
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { 
        if (precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
        this.precio = precio; 
    }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public abstract String getTipoArticulo();

    @Override
    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return "\n====================== ARTICULO " + codigo + " ======================" +
               "\nCodigo: " + codigo +
               "\nNombre: " + nombre +
               "\nPrecio: $" + precio +
               "\nCategoria: " + ((categoria != null) ? categoria.getNombre() : "Sin categoria") +
               "\nTipo: " + getTipoArticulo();
    }
}