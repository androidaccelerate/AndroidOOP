package br.com.androidpro.androidoop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExemploReflexao {

    public List<String> buscaTodosOsMetodosPublicos(Class<?> clazz) {

        final Method[] methods = clazz.getMethods();
        final List<String> nomeDosMetodos = new ArrayList<>();

        for (Method metodo : methods) {
            nomeDosMetodos.add(metodo.getName());
        }

        return nomeDosMetodos;
    }
}
