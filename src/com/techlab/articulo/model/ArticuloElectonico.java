package com.techlab.articulo.model;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;

public class ArticuloElectronico extends Articulo {

    private int garantiaMeses;

    public ArticuloElectronico() {

    }

    public ArticuloElectronico(int garantiaMeses, String nombre, double precio, Categoria categoria) {
        super(nombre, precio, categoria);
        setGarantiaMeses(garantiaMeses);
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        if (garantiaMeses < 0) {
            throw new IllegalArgumentException("La garantía no puede ser negativa");
        }
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String getTipoArticulo() {
        return "Electronico";
    }

    @Override
    public double calcularPrecioFinal() {
        double base = getPrecio();
        
        // regla didáctica: más de 12 meses de garantía suma 10% por servicio extendido
        if (garantiaMeses > 12) {
            return base * 1.10;
        }
        return base;
    }

    @Override
    public String toString() {
        return super.toString() + ", Garantia: " + garantiaMeses + " meses, Precio final: $" + String.format("%.2f", calcularPrecioFinal());
    }
}