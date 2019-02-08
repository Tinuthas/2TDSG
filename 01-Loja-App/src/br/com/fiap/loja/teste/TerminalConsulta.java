package br.com.fiap.loja.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.loja.bean.Produto;
import br.com.fiap.loja.dao.ProdutoDAO;

public class TerminalConsulta {
	
	public static Scanner leitor = new Scanner(System.in);
	
	public static void main(String[] args) {

		Produto p = new Produto();
		System.out.println("Diga o código do produto: ");
		p.setCodigoProduto(leitor.nextInt());
		
		ProdutoDAO dao = new ProdutoDAO();
		
		
		LocalDate hoje = LocalDate.now();
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		
		System.out.println("Na loja Renner na data "+hoje+" ");
		System.out.println(dao.consultarProduto(p));
		

	}

}
