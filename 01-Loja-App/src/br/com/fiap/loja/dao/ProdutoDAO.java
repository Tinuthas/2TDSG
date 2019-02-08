package br.com.fiap.loja.dao;

import br.com.fiap.loja.bean.Produto;

public class ProdutoDAO {

	public String consultarProduto(Produto p) {

		String mensagem = "";
		switch (p.getCodigoProduto()) {
		case 401:
			mensagem = "C�digo " + p.getCodigoProduto() + " Camiseta branca";
			break;
		case 402:
			mensagem = "C�digo " + p.getCodigoProduto() + "Camiseta azul";
			break;
		case 403:
			mensagem = "C�digo " + p.getCodigoProduto() + "Camiseta rosa";
			break;
		default:
			mensagem = "Outro C�digo - Produto n�o encontrado";
			break;
		}
		return mensagem;
	}

}
