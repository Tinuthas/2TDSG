package br.com.fiap.dao;

import br.com.fiap.entity.Motorista;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;

public interface MotoristaDAO {
	
	void cadastrar(Motorista motorista);

	Motorista consultar(int codigo) ;

	void atualizar(Motorista imovel);

	void remover(int codigo) throws SearchNotFoundException;

	void commit() throws CommitException;


}
