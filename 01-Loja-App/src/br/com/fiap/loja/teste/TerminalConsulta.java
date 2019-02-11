package br.com.fiap.loja.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;

import br.com.fiap.loja.bean.Produto;
import br.com.fiap.loja.bo.EstoqueBO;

public class TerminalConsulta {

	public static Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {

		Produto p = new Produto();
		System.out.println("Diga o código do produto: ");
		p.setCodigoProduto(leitor.nextInt());

		leitor.close();

		LocalDate hoje = LocalDate.now();

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Properties prop = PropertySingleton.getInstance();
		System.out.println("Na loja FIAP "+ prop.getProperty("nome") +": " + hoje.format(formatador) + " ");
		System.out.println(EstoqueBO.consultarProduto(p).getDescricao());

	}

}
