package br.com.androidpro.androidoop.enumaracoes;

import br.com.androidpro.androidoop.java.AnotacaoCustomizada;

public enum CalculadoraComplexa {

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
    },
    MULTIPLICACAO {
        @Override
        public int calcula(int num1, int num2) {
            return num1 * num2;
        }
    };

    public interface Calculador {
        int calcula(int num1, int num2);
    }

    public abstract int calcula(int num1, int num2);

    public static void main() {

        final AnotacaoCustomizada annotation = InstrumentosMusicais.class
                .getAnnotation(AnotacaoCustomizada.class);

        final String value = annotation.value();

        if ("teste".equals(value))
            // faz algo

        CalculadoraComplexa.SOMA.calcula(2, 2); // 4
        CalculadoraComplexa.SUBTRACAO.calcula(2, 2); // 0
        CalculadoraComplexa.MULTIPLICACAO.calcula(2, 2); // 4

        fazAlgo(InstrumentosMusicais.ATABAQUE);
    }

    public static void fazAlgo(BuscaClaves buscaClaves){
        buscaClaves.getClaves();
    }
}
