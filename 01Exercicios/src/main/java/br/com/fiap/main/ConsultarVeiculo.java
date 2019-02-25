package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;

public class ConsultarVeiculo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		try {
			System.out.println(dao.consultar(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
		
	}

}
