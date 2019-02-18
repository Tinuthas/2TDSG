package br.com.fiap.teste;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Tipo;
import br.com.fiap.entity.Zoologico;

public class AlterarTeste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();

		// CRIA OBJETO ZOO COM UM ID EXISTENTE NO BANCO
		
		// ATUALIZAR OS DADOS NO BANCO DE DADOS
		
		Zoologico zoo = new Zoologico(1, "Zoo de Cuba", 100, Tipo.PRIVADO, new Date(), new Date(), Calendar.getInstance(), null);
		
		em.merge(zoo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		System.out.println(zoo.getNome());
		
		em.close();
		fabrica.close();
		
	}

}
