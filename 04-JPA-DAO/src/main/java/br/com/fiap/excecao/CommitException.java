package br.com.fiap.excecao;

public class CommitException extends Exception {
	
	public CommitException (String mensagem, Exception e) {
		super(mensagem, e);
		this.print();
		e.printStackTrace();
	}
	
	public void print() {
		System.out.println("-------- TRANTANDO ERRO ---------");
		System.out.println(getMessage());
		System.out.println("PrintStackTrace: ");
	}

}
