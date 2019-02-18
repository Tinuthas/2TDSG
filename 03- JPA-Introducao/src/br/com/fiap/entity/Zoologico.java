package br.com.fiap.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "zoologico", sequenceName = "SQ_T_ZOOLOGICO", allocationSize = 1)
@Table(name = "T_ZOOLOGICO")
public class Zoologico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zoologico")
	@Column(name = "cd_zoologico")
	private int codigo;

	@Column(name = "nm_zoologico", nullable = false, length = 20)
	private String nome;

	@Column(name = "qt_animais")
	private int quantidadeAnimais;

	@Column(name = "ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Temporal(TemporalType.TIME)
	@Column(name = "hr_abertura")
	private Date abertura;

	@Temporal(TemporalType.TIME)
	@Column(name = "hr_fechamento")
	private Date fechamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inauguracao", updatable = false)
	private Calendar dataAbertura;

	@Column(name = "st_emergencia")
	private boolean situacaoEmergencia;

	@Lob
	@Column(name = "fl_logo")
	private byte[] logo;

	@Transient
	private boolean aberto;

	public Zoologico() {

	}

	public Zoologico(int codigo, String nome, int quantidadeAnimais, Tipo tipo, Date abertura, Date fechamento,
			Calendar dataAbertura, byte[] logo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.quantidadeAnimais = quantidadeAnimais;
		this.tipo = tipo;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.dataAbertura = dataAbertura;
		this.logo = logo;
	}
	
	public Zoologico(String nome, int quantidadeAnimais, Tipo tipo, Date abertura, Date fechamento,
			Calendar dataAbertura, boolean situacaoEmergencia, byte[] logo) {
		super();
		this.nome = nome;
		this.quantidadeAnimais = quantidadeAnimais;
		this.tipo = tipo;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.dataAbertura = dataAbertura;
		this.situacaoEmergencia = situacaoEmergencia;
		this.logo = logo;
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

	public int getQuantidadeAnimais() {
		return quantidadeAnimais;
	}

	public void setQuantidadeAnimais(int quantidadeAnimais) {
		this.quantidadeAnimais = quantidadeAnimais;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Date getFechamento() {
		return fechamento;
	}

	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public boolean isSituacaoEmergencia() {
		return situacaoEmergencia;
	}

	public void setSituacaoEmergencia(boolean situacaoEmergencia) {
		this.situacaoEmergencia = situacaoEmergencia;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}


}
