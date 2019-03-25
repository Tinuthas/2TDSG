package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CAMPEONATO")
@SequenceGenerator(name="campeonato", sequenceName = "SQ_T_CAMPEONATO", allocationSize = 1)
public class Campeonato {
	
	@Id
	@Column(name = "cd_campeonato")
	@GeneratedValue(generator="campeonato", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_campeonato", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "vl_premiacao")
	private double premiacao;
	
	@Column(name="ds_local")
	private String local;
	
	@ManyToMany(mappedBy="campeonatos")
	private List<Time> times;

	public Campeonato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campeonato(String nome, double premiacao, String local) {
		super();
		this.nome = nome;
		this.premiacao = premiacao;
		this.local = local;
	}

	public Campeonato(int codigo, String nome, double premiacao, String local) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.premiacao = premiacao;
		this.local = local;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(double premiacao) {
		this.premiacao = premiacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	
}
