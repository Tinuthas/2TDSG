package br.com.fiap.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;

public class InserirMotorista {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		try {
			Motorista m = new Motorista("José", Calendar.getInstance(), null,  Genero.FEMININO);
			dao.cadastrar(m);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		fabrica.close();
		em.close();

	}

}
