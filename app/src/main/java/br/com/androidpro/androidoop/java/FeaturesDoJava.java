package br.com.androidpro.androidoop.java;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeaturesDoJava {

    List<String> operadorDiamante = new ArrayList<>();

    Map<String, List<Object>> mapa = new HashMap<>();

    public void verificaSePodemosUsarAutoCloseable() {

//        // TRY WITH RESOURCES
//        InputStream is = null;
//        try {
//            is = new URL("http://google.com").openConnection().getInputStream()
//            is.read(new byte[1024]);
//        } finally {
//
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    public void verificaSwitchComStrings() {

        String a = "teste";

        switch (a) {

            case "não é um teste":
                Log.i("TAG", "não é um teste");
                break;
            case "teste":
                Log.i("TAG", "Certamente é um teste");
                break;
            default:
                Log.i("TAG", "Não sei do que se trata =/");
        }
    }

    public void verificaMultiCatch() {

        try {

            final Method method = String.class.getDeclaredMethod("lastIndexOfSupplementary", Integer.TYPE, Integer.TYPE);
            method.setAccessible(true);
            method.invoke("testando", 1, 2);

            // MULTI CATCH
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
