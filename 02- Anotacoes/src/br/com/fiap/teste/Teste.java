package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Animal;

public class Teste {

	public static void main(String[] args) {

		// Objeto instanciado
		Animal animal = new Animal();

		// API Reflection: recupera toda a estrutura da classe

		// Nome da Classe
		System.out.println(animal.getClass().getName());

		// Recupera Métodos da Classe
		System.out.println("\nMÉTODOS: ");
		Method[] metodos = animal.getClass().getDeclaredMethods();

		for (Method m : metodos) {
			System.out.println(m.getName());
		}

		// Recuperar e exibir os atributos da classe Animal
		System.out.println("\nATRIBUTOS:");
		Field[] atributos = animal.getClass().getDeclaredFields();

		for (Field a : atributos) {
			System.out.println(a.getName());
		}
		
		// Recuperar as anotações 
		System.out.println("\nANOTAÇÕES:");
		for (Field a : atributos) {
			Coluna c = a.getAnnotation(Coluna.class);
			System.out.println("Campo: " + c.nome());
			System.out.println("Obrigatorio: " + c.nullable());
		}
		
	}

}
