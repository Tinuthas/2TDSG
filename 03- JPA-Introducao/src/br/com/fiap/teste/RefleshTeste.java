package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Zoologico;

public class RefleshTeste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		
		//PESQUISA UM ZOO
		Zoologico zoo = em.find(Zoologico.class, 1);
		
		//EXIBIR O NOME
		System.out.println(zoo.getNome());
		
		//TROCAR O NOME NO JAVA E EXIBIR
		zoo.setNome("Teste");
		System.out.println(zoo.getNome());
		
		//FAZER O REFLESH
		em.refresh(zoo);
		
		//EXIBIR O NOME
		System.out.println(zoo.getNome());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
