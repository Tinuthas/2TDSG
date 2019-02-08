package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Genero;
import br.com.fiap.bean.Pessoa;

public class TesteGeneroCalendar {
	
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
		
		LocalDate hoje = LocalDate.now();
		LocalDate localData = LocalDate.of(2015, 12, 05);
		
		
		LocalTime time = LocalTime.now();
		@SuppressWarnings("all")
		LocalTime horas = LocalTime.of(12, 12);
		@SuppressWarnings("all")
		LocalDateTime dateTime = LocalDateTime.now();
		@SuppressWarnings("all")
		LocalDateTime dataHora = LocalDateTime.of(localData, time);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println(hoje.format(formatador));
		
	}

}
