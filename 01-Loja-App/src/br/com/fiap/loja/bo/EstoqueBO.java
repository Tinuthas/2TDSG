package br.com.fiap.loja.bo;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public static ProdutoTO consultarProduto(ProdutoTO p) {

		String mensagem = "";
		switch (p.getCodigoProduto()) {
		case 401:
			mensagem = "Código " + p.getCodigoProduto() + " Camiseta branca";
			break;
		case 402:
			mensagem = "Código " + p.getCodigoProduto() + " Camiseta azul";
			break;
		case 403:
			mensagem = "Código " + p.getCodigoProduto() + " Camiseta rosa";
			break;
		default:
			mensagem = "Outro Código - Produto não encontrado";
			break;
		}
		p.setDescricao(mensagem);
		return p;

	}

}
