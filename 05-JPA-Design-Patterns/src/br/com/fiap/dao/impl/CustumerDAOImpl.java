package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CustumerDAO;
import br.com.fiap.entity.Custumer;

public class CustumerDAOImpl extends GenericDAOImpl<Custumer, Integer> implements CustumerDAO {

	public CustumerDAOImpl(EntityManager em) {
		super(em);
		
	}

}
