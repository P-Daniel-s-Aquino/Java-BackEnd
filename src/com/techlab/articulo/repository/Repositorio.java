package com.techlab.articulo.repository;

import java.util.ArrayList;
import java.util.List;

import com.techlab.articulo.interfaces.Identificable;

public class Repositorio<T extends Identificable> {
    private final ArrayList<T> lista = new ArrayList<>();

    public void agregar(T objeto){
        if(objeto == null){
            throw new IllegalArgumentException("No se puede agregar null");
        }
        lista.add(objeto);
    }

    public List<T> listar(){
        return new ArrayList<>(lista);
    }

    public T buscarPorCodigo(int codigo){
        for (T item : lista) {
            if(item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    public boolean eliminarPorCodigo(int codigo){
        T encontrado = buscarPorCodigo(codigo);
        if(encontrado != null){
            return lista.remove(encontrado);
        }
        return false;
    }

    public boolean estaVacio(){
        return lista.isEmpty();
    }
}
