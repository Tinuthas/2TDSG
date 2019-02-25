package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Veiculo;

public class InserirVeiculo {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		Veiculo veiculo = new Veiculo("FSF", "Amarelo", 2018);
		
		try {
			dao.cadastrar(veiculo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fabrica.close();
		em.close();
		
		

	}

}
