package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.bean.Animal;

public class Teste {

	public static void main(String[] args) {

		// Objeto instanciado
		Animal animal = new Animal();

		// API Reflection: recupera toda a estrutura da classe

		// Nome da Classe
		System.out.println(animal.getClass().getName());

		// Recupera M�todos da Classe
		System.out.println("\nM�TODOS: ");
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
	}

}
