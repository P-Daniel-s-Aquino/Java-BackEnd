package com.techlab.articulo.utils;

/**
 * Clase utilitaria de validaciones.
 * Centraliza las reglas que se repiten en los menús.
 */
public final class Validaciones {

    private Validaciones() {
        // evita instanciación
    }

    /** Valida que el texto no sea nulo ni vacío después de trim(). */
    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /** Valida que el texto no supere la longitud máxima. */
    public static boolean validarLongitudMaxima(String texto, int maximo) {
        if (texto == null) {
            return false;
        }
        return texto.trim().length() <= maximo;
    }

    /** Valida que un entero sea >= 0. */
    public static boolean validarNoNegativo(int valor) {
        return valor >= 0;
    }

    /** Valida que un double sea >= 0. */
    public static boolean validarNoNegativo(double valor) {
        return valor >= 0;
    }
}