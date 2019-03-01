

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.EstoqueBOStub;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProduto;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProdutoResponse;
import org.apache.ws.axis2.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {
	
	public static void main(String[] args) {
		
		
		
		String nome = "FIAP";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 	DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o código do produto desejado: ");
		Scanner scanner = new Scanner(System.in);
		int codigo = scanner.nextInt();
		scanner.close();
		
		try {
			
			EstoqueBOStub stub = new EstoqueBOStub();
			ConsultarProduto cp = new ConsultarProduto();
			cp.setCodigo(codigo);
			ConsultarProdutoResponse response =  stub.consultarProduto(cp);
			ProdutoTO produto = response.get_return();
		
			System.out.println(produto.getDescricao());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}
}
