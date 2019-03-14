package br.com.fiap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CustumerDAO;
import br.com.fiap.dao.impl.CustumerDAOImpl;
import br.com.fiap.entity.Custumer;
import br.com.fiap.entity.Gender;
import br.com.fiap.exception.CommitException;

class CustumerDAOTest {
	
	private static CustumerDAO dao;
	private static Custumer custumer;
	
	@BeforeAll // Método executado antes de todos os testes
	public static void init() {
		// ARRANGE: INSTANCIAR OS OBJETOS
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new CustumerDAOImpl(em);
	}
	
	@BeforeEach //Método executado antes de cada testes
	void beforeTest() {
		custumer = new Custumer("Teste", Calendar.getInstance(), Gender.MALE, null);
		
		// ACT: CADASTRAR CLIENTE
				try {
					dao.create(custumer);
					dao.commit();
				} catch (CommitException e) {
					e.printStackTrace();
					fail("Falha no teste");
				}
	}
	
	@Test
	@DisplayName("Teste de Cadastro com sucesso")
	void createTest() {	
		// ASSERT: VALIDAR O RESULTADO
		
		// VALIDAR SE A SEQUENCIA GEROU UM CÓDIGO PARA O CUSTUMER
		assertNotEquals(custumer.getId(), 0);
	}
	
	@Test
	@DisplayName("Teste de busca com sucesso")
	void read() {
		
		try {
			dao.create(custumer);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no Cadastro do teste de busca");
		}
		
		// Act - pesquisar o custumer que foi cadastrado
		try {
			Custumer search = dao.read(custumer.getId());
			assertNotNull(search);
			assertEquals(search.getId(), custumer.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
			
		}
		
	}
	
	@Test
	@DisplayName("Teste de atualização com sucesso")
	void update() {
	
		// Atualizar o custumer cadastro
		try {
			custumer.setName("Teste2");
			custumer.setGander(Gender.FEMALE);
			dao.update(custumer);
			dao.commit();
		}catch(Exception e ) {
			e.printStackTrace();
			fail("Erro no Update");
		}
		// Pesquisar o custumer
		try {
			Custumer search = dao.read(custumer.getId());
			// Validar se as alterações foram realizados 
			assertNotNull(search);
			assertNotEquals(search.getName(), "Teste");
			assertEquals(search.getGander(), custumer.getGander());
			assertEquals(search.getId(), custumer.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
			
		}
	
	}
	
	@Test
	@DisplayName("Teste de deletar com sucesso")
	void delete() {

		// Remover o custumer cadastrado
		try {
			dao.delete(custumer.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha ao deletar");
		}
		
		// Pesquisar o custumer que foi removido
		Custumer search = null;
		try {
			search = dao.read(custumer.getId());
			// Validar se as alterações foram realizados 	
		} catch (Exception e) {
			assertNull(search);
		}
		
	}
	

}
