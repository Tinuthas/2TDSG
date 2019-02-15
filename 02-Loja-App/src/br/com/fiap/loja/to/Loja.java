package br.com.fiap.loja.to;

public class Loja {

	private String razaoSocial;
	private ProdutoTO produto;

	public Loja(String razaoSocial, ProdutoTO produto) {
		super();
		this.razaoSocial = razaoSocial;
		this.produto = produto;
	}

	public Loja() {
		super();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public ProdutoTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
	}

}
