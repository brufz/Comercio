package com.comercio.comercioEletronico.factory;

import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.service.CategoriaService;

import java.util.ArrayList;
import java.util.List;

public class CategoriaFactory {

    public static Categoria getPrimeiraCategoria(){
        return new Categoria(1L, "smartphone", "celular nota 1000");
    }
    public static Categoria getSegundaCategoria(){
        return new Categoria(1L, "smartphone", "celular nota 1000");
    }
    public static Categoria getTerceiraCategoria(){
        return new Categoria(1L, "smartphone", "celular nota 1000");
    }


    public static List<Categoria> getCategorias(){
        List <Categoria> categorias = new ArrayList<>();
        categorias.add(getPrimeiraCategoria());
        categorias.add(getSegundaCategoria());
        categorias.add(getTerceiraCategoria());
        return categorias;
    }
}
