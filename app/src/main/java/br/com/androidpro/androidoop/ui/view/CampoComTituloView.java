package br.com.androidpro.androidoop.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.androidpro.androidoop.R;
import br.com.androidpro.androidoop.ui.activity.CamposComTituloActivity;

public class CampoComTituloView extends RelativeLayout {

    private TextView titulo;
    private TextView setaCampo;
    private EditText campo;
    private CamposComTituloActivity.OnClicaNoTitulo callback;

    public CampoComTituloView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CampoComTituloView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CampoComTituloView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_campo_com_titulo, this);

        // inicializa as variáveis
        titulo = (TextView) findViewById(R.id.titulo_campo);
        setaCampo = (TextView) findViewById(R.id.seta_campo);
        campo = (EditText) findViewById(R.id.campo_editavel);

        final OnClickListener ajustaVisibilidadeDoContainer = new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (campo.getVisibility() == View.VISIBLE) {
                    campo.setVisibility(View.GONE);
                    setaCampo.setText("\\/");
                } else {
                    campo.setVisibility(View.VISIBLE);
                    setaCampo.setText("/\\");
                }
                callback.clicouNoTitulo(CampoComTituloView.this);
            }
        };

        titulo.setOnClickListener(ajustaVisibilidadeDoContainer);
        setaCampo.setOnClickListener(ajustaVisibilidadeDoContainer);
    }

    public void esconde() {
        campo.setVisibility(View.GONE);
        setaCampo.setText("\\/");
    }

    public void setOnClicaNoTitulo(CamposComTituloActivity.OnClicaNoTitulo callback) {
        this.callback = callback;
    }
}
