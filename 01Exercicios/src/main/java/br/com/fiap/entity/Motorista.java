package br.com.fiap.entity;

import java.util.Calendar;

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

@Entity
@Table(name = "T_MOTORISTA")
@SequenceGenerator(name = "motorista", sequenceName = "SQ_T_MOTORISTA", allocationSize = 1)
public class Motorista {

	@Id
	@GeneratedValue(generator = "motorista", strategy = GenerationType.SEQUENCE)
	@Column(name = "nr_carteira")
	private int carteira;

	@Column(name = "nm_motorista", length = 150)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;

	@Lob
	@Column(name = "fl_carteira")
	private byte[] fotoCarteira;

	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public Motorista() {
		super();
	}

	public Motorista(int carteira, String nome, Calendar dataNascimento, byte[] fotoCarteira, Genero genero) {
		super();
		this.carteira = carteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.fotoCarteira = fotoCarteira;
		this.genero = genero;
	}

	public Motorista(String nome, Calendar dataNascimento, byte[] fotoCarteira, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.fotoCarteira = fotoCarteira;
		this.genero = genero;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getFotoCarteira() {
		return fotoCarteira;
	}

	public void setFotoCarteira(byte[] fotoCarteira) {
		this.fotoCarteira = fotoCarteira;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
