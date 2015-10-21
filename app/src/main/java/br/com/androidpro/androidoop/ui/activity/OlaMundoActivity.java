package br.com.androidpro.androidoop.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.androidpro.androidoop.R;

public class OlaMundoActivity extends Activity {

    // a quem pertence esta variavel??
    private static final String TEXTO_OLA = "" + System.currentTimeMillis();

    // e esta?
    private TextView labelOlaMundo;

    // e este metodo?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ola_mundo_activity);

        labelOlaMundo = (TextView) findViewById(R.id.label_ola_mundo);
        labelOlaMundo.setText(TEXTO_OLA);
        labelOlaMundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelOlaMundo.setText(TEXTO_OLA);
            }
        });
    }

    // e este metodo?
    private static String getOla() {
        return "" + System.currentTimeMillis();
    }
}
