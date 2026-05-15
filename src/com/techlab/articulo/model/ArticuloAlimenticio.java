package com.techlab.articulo.model;

public class ArticuloAlimenticio extends Articulo {
    private int diasParaVencimiento;

    public ArticuloAlimenticio(int diasParaVencimiento, 
                               String nombre, double precio, Categoria categoria) {
        super(nombre, precio, categoria);
        setDiasParaVencimiento(diasParaVencimiento);
    }

    public int getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int diasParaVencimiento) {
        if (diasParaVencimiento < 0) {
            throw new IllegalArgumentException("Los días no pueden ser negativos");
        }
        this.diasParaVencimiento = diasParaVencimiento;
    }

    @Override
    public String getTipoArticulo() {
        return "Alimenticio";
    }

    @Override
    public double calcularPrecioFinal() {
        double base = getPrecio();
        
        if (diasParaVencimiento <= 3) { 
            return base * 0.70; // 30% off
        }
        if (diasParaVencimiento <= 10) {
            return base * 0.85; // 15% off
        }
        return base;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", Dias para vencer: " + diasParaVencimiento +
               ", Precio final: $" + String.format("%.2f", calcularPrecioFinal()
            );
    }
}