package br.com.fiap.loja.bean;

public class Loja {

	private String razaoSocial;
	private Produto produto;

	public Loja(String razaoSocial, Produto produto) {
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
