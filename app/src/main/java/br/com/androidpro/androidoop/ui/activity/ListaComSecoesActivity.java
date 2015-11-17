package br.com.androidpro.androidoop.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.androidpro.androidoop.AdapterComSecoes;
import br.com.androidpro.androidoop.R;

public class ListaComSecoesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_de_string_activity);

        // Busca referência da View
        final ListView listaComSecoes = (ListView) findViewById(R.id.lista_de_string);

        // Cria e seta o adapter
        final AdapterComSecoes adapter = new AdapterComSecoes();
        listaComSecoes.setAdapter(adapter);

        // Dados de teste
        final List<String> strings = new ArrayList<>();
        strings.add("André");
        strings.add("Alexandre");
        strings.add("Bruno");
        strings.add("Carlos");
        strings.add("Carolina");
        strings.add("Daniel");
        strings.add("Dante");
        strings.add("Evaldo");
        strings.add("Eduardo");
        strings.add("Fabiana");
        strings.add("Helena");
        strings.add("Lima");
        strings.add("Thiago");
        strings.add("Tiago");
        strings.add("Roberto"); // fora de ordem
        strings.add("Henrique");
        strings.add("Laura");
        strings.add("Raul");
        strings.add("Luiz");
        strings.add("Victor");
        strings.add("Mariana");

        // Seta os dados
        adapter.setList(strings);
    }
}
