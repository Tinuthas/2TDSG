package br.com.fiap.loja.bo;

import org.apache.log4j.Logger;

import br.com.fiap.loja.teste.TerminalConsulta;
import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	private static Logger log = Logger.getLogger(EstoqueBO.class);

	public static ProdutoTO consultarProduto(ProdutoTO p) {

		String mensagem = "";
		switch (p.getCodigoProduto()) {
		case 401:
			log.debug("Código " + p.getCodigoProduto() + " Camiseta branca");
			//mensagem = "Código " + p.getCodigoProduto() + " Camiseta branca";
			break;
		case 402:
			log.debug("Código " + p.getCodigoProduto() + " Camiseta azul");
			//mensagem = "Código " + p.getCodigoProduto() + " Camiseta azul";
			break;
		case 403:
			log.debug("Código " + p.getCodigoProduto() + " Camiseta rosa");
			//mensagem = "Código " + p.getCodigoProduto() + " Camiseta rosa";
			break;
		default:
			log.error("Outro Código - Produto não encontrado");
			// mensagem = "Outro Código - Produto não encontrado";
			break;
		}
		p.setDescricao(mensagem);
		return p;

	}

}
