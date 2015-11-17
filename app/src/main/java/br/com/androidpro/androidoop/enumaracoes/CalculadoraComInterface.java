package br.com.androidpro.androidoop.enumaracoes;

public enum CalculadoraComInterface implements Calculador {

    SOMA {
        @Override
        public int calcula(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACAO {
        @Override
        public int calcula(int num1, int num2) {
            return num1 - num2;
        }
    }
}

interface Calculador {
    int calcula(int num1, int num2);
}
