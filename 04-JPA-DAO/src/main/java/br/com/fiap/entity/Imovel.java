package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * T_IMOVEL
 * 		*cd_imovel (PK)
 * 		ds_tipo (VARCHAR) (Enum...)
 * 		vl_area (NUMBER)	
 * 		dt_construcao (DATE)
 * 		*ds_logradouro (VARCHAR(100))
 */

@Entity
@SequenceGenerator(name="imovel", sequenceName="SQ_T_IMOVEL", allocationSize = 1)
@Table(name="T_IMOVEL")
public class Imovel {
	
	@Id
	@GeneratedValue(generator="imovel", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_imovel")
	private int codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", nullable=false)
	private Tipo tipo;
	
	@Column(name="vl_area")
	private double area;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_construcao")
	private Calendar dataConstrucao;
	
	@Column(name="ds_logradouro", length=100, nullable=false)
	private String logradouro;
	
	public Imovel(int codigo, Tipo tipo, double area, Calendar dataConstrucao, String logradouro) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.area = area;
		this.dataConstrucao = dataConstrucao;
		this.logradouro = logradouro;
	}

	public Imovel(Tipo tipo, double area, Calendar dataConstrucao, String logradouro) {
		super();
		this.tipo = tipo;
		this.area = area;
		this.dataConstrucao = dataConstrucao;
		this.logradouro = logradouro;
	}

	public Imovel() {

	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Calendar getDataConstrucao() {
		return dataConstrucao;
	}

	public void setDataConstrucao(Calendar dataConstrucao) {
		this.dataConstrucao = dataConstrucao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	

}
