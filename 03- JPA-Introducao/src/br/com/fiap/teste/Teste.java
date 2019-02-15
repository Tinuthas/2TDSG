package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		
		// CRIAR UM GERENCIADOR DE ENTIDADES 
		// ENTITY MANAGER
		
		// FABRICA														// persistence.xml				
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		fabrica.close();

	}

}
