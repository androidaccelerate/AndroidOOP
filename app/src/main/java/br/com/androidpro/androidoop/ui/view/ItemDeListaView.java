package br.com.androidpro.androidoop.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import br.com.androidpro.androidoop.R;

public class ItemDeListaView extends LinearLayout {

    private TextView tituloView;
    private TextView valorView;

    public ItemDeListaView(Context context) {
        super(context);
        init();
    }

    public ItemDeListaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemDeListaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ItemDeListaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_item_de_lista, this);
        tituloView = (TextView) findViewById(R.id.item_lista_titulo);
        valorView = (TextView) findViewById(R.id.item_lista_valor);
    }

    public ItemDeListaView bind(String titulo, String valor) {

        if (titulo != null) {
            tituloView.setVisibility(View.VISIBLE);
            tituloView.setText(titulo);
        } else {
            tituloView.setVisibility(View.GONE);
        }
        valorView.setText(valor);

        return this;
    }
}
