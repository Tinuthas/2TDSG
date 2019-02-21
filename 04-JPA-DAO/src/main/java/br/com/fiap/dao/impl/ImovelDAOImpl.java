package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.entity.Imovel;
import br.com.fiap.excecao.CommitException;

public class ImovelDAOImpl implements ImovelDAO {

	private EntityManager em;

	public ImovelDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Imovel imovel) {
		em.persist(imovel);
	}

	public Imovel consultar(int codigo) {
		Imovel i = em.find(Imovel.class, codigo);
//		if (i.equals(null)) {
//			throw new Exception("Objeto Imov�l n�o encontrado");
//		}
		return i;
	}

	public void atualizar(Imovel imovel) {
		em.merge(imovel);
	}

	public void remover(int codigo) {
		em.remove(consultar(codigo));
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
