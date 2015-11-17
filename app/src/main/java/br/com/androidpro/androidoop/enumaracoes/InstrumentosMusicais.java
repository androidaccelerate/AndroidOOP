package br.com.androidpro.androidoop.enumaracoes;

import br.com.androidpro.androidoop.java.AnotacaoCustomizada;

@AnotacaoCustomizada(value = "outro teste", calculadora = CalculadoraComplexa.MULTIPLICACAO)
public enum InstrumentosMusicais implements BuscaClaves {

    VIOLINO("Clave de Sol"),

    GUITARRA("Clave de Sol"),

    PIANO("Clave de Sol e Fá"),

    BAIXO("Clave de Fá"),

    ATABAQUE;

    private final String claves;

    InstrumentosMusicais() {
        this.claves = null;
    }

    InstrumentosMusicais(String claves) {
        this.claves = claves;
    }

    @Override
    public String getClaves() {
        return claves;
    }
}

interface BuscaClaves {
    String getClaves();
}
