package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="time", sequenceName="SQ_T_TIME", allocationSize=1)
public class Time {
	
	@Id
	@Column(name="cd_time")
	@GeneratedValue(generator="time", strategy=GenerationType.SEQUENCE) 
	private int codigo;
	
	@OneToOne(mappedBy="time")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy="time", cascade= CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "T_TIME_CAMPEONATO", joinColumns= @JoinColumn(name=""), inverseJoinColumns = @JoinColumn(name=""))
	private List<Campeonato> campeonatos; 
	
	@Column(name="nm_time", nullable = false)
	private String nome;
	
	@Column(name="nr_titulo")
	private int titulo;
	
	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Time(Tecnico tecnico, String nome, int titulo) {
		super();
		this.tecnico = tecnico;
		this.nome = nome;
		this.titulo = titulo;
	}

	public Time(int codigo, Tecnico tecnico, String nome, int titulo) {
		super();
		this.codigo = codigo;
		this.tecnico = tecnico;
		this.nome = nome;
		this.titulo = titulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public void addJogador(Jogador j) {
		//adicionar o jogador na lista
		jogadores.add(j);
		//adicionar o time no jogador
		j.setTime(this);
		
	}

	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	
	
	
	
	
}
