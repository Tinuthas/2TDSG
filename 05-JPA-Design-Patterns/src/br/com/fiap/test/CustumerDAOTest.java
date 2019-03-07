package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CustumerDAO;
import br.com.fiap.dao.impl.CustumerDAOImpl;
import br.com.fiap.entity.Custumer;
import br.com.fiap.entity.Gender;
import br.com.fiap.exception.CommitException;

class CustumerDAOTest {

	@Test
	void createTest() {
		
		// ARRANGE: INSTANCIAR OS OBJETOS
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		CustumerDAO dao = new CustumerDAOImpl(em);
		Custumer c = new Custumer("Teste", new GregorianCalendar(1999, Calendar.MARCH, 15), Gender.OTHERS, null);
		
		// ACT: CADASTRAR CLIENTE
		try {
			dao.create(c);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		
		// ASSERT: VALIDAR O RESULTADO
		
		// VALIDAR SE A SEQUENCIA GEROU UM CÓDIGO PARA O CUSTUMER
		assertNotEquals(c.getId(), 0);
	}

}
