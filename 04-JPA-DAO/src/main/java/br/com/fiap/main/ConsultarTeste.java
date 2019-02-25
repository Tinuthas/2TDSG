package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entity.Imovel;

public class ConsultarTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		ImovelDAO dao = new ImovelDAOImpl(em);
		
		
		try {
			System.out.println(dao.consultar(1));
			Imovel imovel = dao.consultar(1);
			System.out.println();
			System.out.println(imovel.getCodigo());
			System.out.println(imovel.getLogradouro());
			System.out.println(imovel.getArea());
			System.out.println(imovel.getDataConstrucao());
			System.out.println(imovel.getTipo());

			
			
		} catch (Exception e) {
		}
		
		em.close();
		fabrica.close();
		
	}

}
