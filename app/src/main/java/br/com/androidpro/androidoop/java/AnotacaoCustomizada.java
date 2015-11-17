package br.com.androidpro.androidoop.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.androidpro.androidoop.enumaracoes.CalculadoraComplexa;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotacaoCustomizada {

    String value() default "teste";

    CalculadoraComplexa calculadora();

}
