package br.com.fiap.loja.dao;

import br.com.fiap.loja.bean.Produto;

public class ProdutoDAO {

	public String consultarProduto(Produto p) {

		String mensagem = "";
		switch (p.getCodigoProduto()) {
		case 401:
			mensagem = "Código " + p.getCodigoProduto() + " Camiseta branca";
			break;
		case 402:
			mensagem = "Código " + p.getCodigoProduto() + "Camiseta azul";
			break;
		case 403:
			mensagem = "Código " + p.getCodigoProduto() + "Camiseta rosa";
			break;
		default:
			mensagem = "Outro Código - Produto não encontrado";
			break;
		}
		return mensagem;
	}

}
