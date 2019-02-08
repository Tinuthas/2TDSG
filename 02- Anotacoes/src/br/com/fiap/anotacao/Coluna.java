package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // Utilizar em atributos
public @interface Coluna {

	String nome();

	boolean nullable();

}
