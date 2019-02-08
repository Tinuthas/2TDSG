package br.com.fiap.loja.bean;

public class Produto {

	private int codigoProduto;
	private String name;
	private Cor descricaoProduto;

	public Produto(int codigoProduto, String name, Cor descricaoProduto) {
		super();
		this.codigoProduto = codigoProduto;
		this.name = name;
		this.descricaoProduto = descricaoProduto;
	}

	public Produto() {
		super();
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cor getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(Cor descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

}
