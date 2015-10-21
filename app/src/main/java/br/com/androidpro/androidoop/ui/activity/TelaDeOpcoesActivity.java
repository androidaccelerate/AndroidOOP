package br.com.androidpro.androidoop.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.androidpro.androidoop.R;

public class TelaDeOpcoesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_de_opcoes_activity);
    }

    public void irParaOlaMundo(View v) {
        startActivity(new Intent(this, OlaMundoActivity.class));
    }

    public void irParaLeakDeMemoria(View v) {
        startActivity(new Intent(this, LeakDeMemoriaActivity.class));
    }
}
