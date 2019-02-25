package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;

public class MotoristaDAOImpl implements MotoristaDAO{
	
	private EntityManager em;
	
	public MotoristaDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void cadastrar(Motorista motorista) {
		em.persist(motorista);
		
	}

	@Override
	public Motorista consultar(int codigo) throws SearchNotFoundException {
		Motorista m = em.find(Motorista.class, codigo);
		if(m == null)
			throw new SearchNotFoundException();
		return m;
	}

	@Override
	public void atualizar(Motorista motorista) {
		em.merge(motorista);
	}

	@Override
	public void remover(int codigo) throws SearchNotFoundException {
		Motorista m = consultar(codigo);
		if(m == null)
			throw new SearchNotFoundException();
		em.remove(m);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

	
}
