package br.com.androidpro.androidoop.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import br.com.androidpro.androidoop.R;
import br.com.androidpro.androidoop.ui.view.CampoComTituloView;

public class CamposComTituloActivity extends Activity {

    public interface OnClicaNoTitulo {
        void clicouNoTitulo(CampoComTituloView viewClicada);
    }

    private CampoComTituloView ultimaViewClicada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campos_com_titulo_activity);

        final CampoComTituloView campo1 = (CampoComTituloView) findViewById(R.id.campo1);
        final CampoComTituloView campo2 = (CampoComTituloView) findViewById(R.id.campo2);
        final CampoComTituloView campo3 = (CampoComTituloView) findViewById(R.id.campo3);

        final OnClicaNoTitulo callback = new OnClicaNoTitulo() {
            @Override
            public void clicouNoTitulo(CampoComTituloView viewClicada) {

                if (ultimaViewClicada != null
                        && !ultimaViewClicada.equals(viewClicada)) {

                    ultimaViewClicada.esconde();
                }

                ultimaViewClicada = viewClicada;
            }
        };

        campo1.setOnClicaNoTitulo(callback);
        campo2.setOnClicaNoTitulo(callback);
        campo3.setOnClicaNoTitulo(callback);

    }
}
