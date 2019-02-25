package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;

public class VeiculoDAOImpl implements VeiculoDAO {
	
	private EntityManager em;
	
	
	
	public VeiculoDAOImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Veiculo veiculo) {
		em.persist(veiculo);
		
	}

	public Veiculo consultar(int codigo){
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		return veiculo;
	}

	public void atualizar(Veiculo imovel) {
		em.merge(imovel);
		
	}

	public void remover(int codigo) throws SearchNotFoundException {
		Veiculo veiculo = consultar(codigo);
		if(veiculo == null )
			throw new SearchNotFoundException();
		em.remove(veiculo);

	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException("Commit deu ruim", e);
		}
		
	}

}
