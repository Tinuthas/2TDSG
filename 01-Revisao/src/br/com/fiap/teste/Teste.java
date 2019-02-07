package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Genero;
import br.com.fiap.bean.Pessoa;

public class Teste {
	
	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.setSexo(Genero.OUTROS);
		
		Calendar data = Calendar.getInstance();
		Calendar data2 = new GregorianCalendar(2010, 11, 25);
		p.setDataNascimento(data);
		
		//Precisamos formatar a Data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(data.getTime()));
		System.out.println(sdf.format(data2.getTime()));
		
		System.out.println(p.getSexo());
	}

}
