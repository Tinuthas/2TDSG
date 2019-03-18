package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_TECNICO")
@SequenceGenerator(name = "tecnico", sequenceName="SQ_T_JOGADOR", allocationSize = 1)
public class Tecnico {
	
	@Id
	@Column(name="cd_tecnico")
	@GeneratedValue(generator="tecnico", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="cd_time")
	private Time time;
	
	@Column(name="nm_tecnico", nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	

}
