package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JOGADOR")
@SequenceGenerator(name ="jogador", sequenceName= "SQ_T_JOGADOR", allocationSize = 1)
public class Jogador {
	
	@Id
	@Column(name = "cd_jogador")
	@GeneratedValue(generator = "jogador", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_time")
	private Time time;
	
	@Column(name = "nm_jogador", nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_posicao")
	private Posicao posicao;

}
