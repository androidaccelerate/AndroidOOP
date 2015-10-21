package br.com.androidpro.androidoop.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import br.com.androidpro.androidoop.R;

public class LeakDeMemoriaActivity extends Activity {

    public static LeakDeMemoriaActivity ACTIVITY;
    public static Context CONTEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ola_mundo_activity);
        ACTIVITY = this;
    }
}
