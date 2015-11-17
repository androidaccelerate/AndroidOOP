package br.com.androidpro.androidoop.generics;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Exemplo de genéricos
public interface MinhaLista<T> {
    MinhaLista<T> adicionaUmItem(int position, T object);
}

interface Generico<T> {
}

class Impl implements Generico<String> {
}

class MinhaListaDeArray<T> implements MinhaLista<T> {

    private List<T> dados = new ArrayList<T>(); // inicio dos dados

    public MinhaLista<T> adicionaUmItem(int posicao, T object) {
        dados.add(posicao, object);
        return this; // retornando a propria instancia
    }
}

class MinhaListaDeString implements MinhaLista<String> {

    private String[] dados = new String[128]; // inicio dos dados

    public MinhaLista<String> adicionaUmItem(int posicao, String object) {
        dados[posicao] = object;
        return this;
    }
}

class Test {

    void main() {
        MinhaLista<String> lista = new MinhaListaDeArray<String>()
                .adicionaUmItem(0, "a")
                .adicionaUmItem(1, "b")
                .adicionaUmItem(2, "c");

        MinhaLista<String> lista2 = new MinhaListaDeString()
                .adicionaUmItem(0, "a")
                .adicionaUmItem(1, "b")
                .adicionaUmItem(2, "c");

        List<CharSequence> strings = Arrays.<CharSequence>asList("a", "b", "c");

        Runnable executavel = new Runnable() {
            @Override
            public void run() {
                Log.i("THREAD_TAG", "Estou na Thread:" + Thread.currentThread().getName());
            }
        };

        new Thread(executavel).start();
    }
}

