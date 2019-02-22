package br.com.fiap.loja.bo;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public static ProdutoTO consultarProduto(int codigo) {
		
		String mensagem = "";
		switch (codigo) {
		case 401:
			mensagem = "Código " + codigo + " Camiseta branca";
			break;
		case 402:
			mensagem = "Código " + codigo + " Camiseta azul";
			break;
		case 403:
			mensagem = "Código " + codigo+ " Camiseta rosa";
			break;
		default:
			mensagem = "Produto Não Cadastrado";
		}
		ProdutoTO p = new ProdutoTO();
		p.setDescricao(mensagem);
		return p;
	}

}
