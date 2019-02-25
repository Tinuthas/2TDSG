package br.com.fiap.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entity.Imovel;
import br.com.fiap.entity.Tipo;

public class AtualizarTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		ImovelDAO dao = new ImovelDAOImpl(em);
		Imovel imovel = new Imovel(1,Tipo.APARTAMENTO, 50, Calendar.getInstance(), "Av. Paulista");
		
		try {
			dao.atualizar(imovel);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		em.close();
		
		fabrica.close();
		
		
	}

}
