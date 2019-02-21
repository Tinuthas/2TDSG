package br.com.fiap.dao;

import br.com.fiap.entity.Imovel;
import br.com.fiap.excecao.CommitException;

public interface ImovelDAO {
	
	void cadastrar(Imovel imovel);
	
	Imovel consultar(int codigo) throws Exception;
	
	void atualizar(Imovel imovel);
	
	void remover(int codigo);
	
	void commit() throws CommitException;

}
