

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

public class TerminalConsulta {
	private static Logger log = Logger.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {
		log.warn("In�cio da Aplica��o");
		String nome = "FIAP";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 	DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o c�digo do produto desejado: ");
		Scanner scanner = new Scanner(System.in);
		int codigo = scanner.nextInt();
		scanner.close();
		ProdutoTO produto = null;
		try {
			produto = EstoqueBO.consultarProduto(codigo);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		System.out.println(produto.getDescricao());
		log.warn("Final da Aplica��o");
	}
}
