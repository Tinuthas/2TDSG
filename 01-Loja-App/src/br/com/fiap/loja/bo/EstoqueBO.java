package br.com.fiap.loja.bo;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public static ProdutoTO consultarProduto(ProdutoTO p) {

		String mensagem = "";
		switch (p.getCodigoProduto()) {
		case 401:
			mensagem = "C�digo " + p.getCodigoProduto() + " Camiseta branca";
			break;
		case 402:
			mensagem = "C�digo " + p.getCodigoProduto() + " Camiseta azul";
			break;
		case 403:
			mensagem = "C�digo " + p.getCodigoProduto() + " Camiseta rosa";
			break;
		default:
			mensagem = "Outro C�digo - Produto n�o encontrado";
			break;
		}
		p.setDescricao(mensagem);
		return p;

	}

}
