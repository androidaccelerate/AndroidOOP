package br.com.androidpro.androidoop;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import br.com.androidpro.androidoop.ui.view.ItemDeListaView;

public class AdapterComSecoes extends BaseAdapter {

    private List<String> itens;
    private SparseArray<String> titulos;

    @Override
    public int getCount() {
        return itens == null ? 0 : itens.size();
    }

    @Override
    public String getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemDeListaView view;

        // convertView sempre será do tipo ItemDeListaView
        if (convertView == null) {
            view = new ItemDeListaView(parent.getContext());
        } else {
            view = (ItemDeListaView) convertView;
        }

        return view.bind(titulos.get(position), getItem(position));
    }

    public void setList(List<String> valores) {

        // Organiza a lista em ordem alfabética
        Collections.sort(valores);
        itens = valores;

        // Agora iteramos na lista e sempre que mudarmos
        // de letra iremos guardar um título para a sessão
        titulos = new SparseArray<>();
        char ultimaLetraDoIndice = ' ';

        for (int i = 0; i < valores.size(); i++) {

            final char letraDoIndice = valores.get(i).charAt(0);

            if (i == 0 || letraDoIndice != ultimaLetraDoIndice) {
                ultimaLetraDoIndice = letraDoIndice;
                titulos.put(i, "Letra " + ultimaLetraDoIndice);
            }
        }
    }
}
