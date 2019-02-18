package br.com.fiap.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Tipo;
import br.com.fiap.entity.Zoologico;

public class CadastroTeste {

	public static void main(String[] args) {
		
		// CRIAR UM GERENCIADOR DE ENTIDADES 
		// ENTITY MANAGER
		
		// FABRICA														// persistence.xml				
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Zoologico zoo = new Zoologico("Zoo São Paulo", 10, Tipo.PRIVADO, new Date(), new Date(), Calendar.getInstance(), false, null);
		
		em.persist(zoo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();

	}

}
