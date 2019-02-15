package br.com.fiap.loja.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.singleton.PropertySingleton;
import br.com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	public static Scanner leitor = new Scanner(System.in);
	private static Logger log = Logger.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {
		
		log.warn("Início da Aplicação");
		
		ProdutoTO p = new ProdutoTO();
		System.out.print("Diga o código do produto: ");
		p.setCodigoProduto(leitor.nextInt());

		leitor.close();

		LocalDate hoje = LocalDate.now();

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Properties prop = PropertySingleton.getInstance();
		log.debug("Na loja " + prop.getProperty("nome") + ": " + hoje.format(formatador));
		System.out.println("Na loja " + prop.getProperty("nome") + ": " + hoje.format(formatador) + " ");
		System.out.println(EstoqueBO.consultarProduto(p).getDescricao());
		
		log.warn("Final da Aplicação");

	}

}
