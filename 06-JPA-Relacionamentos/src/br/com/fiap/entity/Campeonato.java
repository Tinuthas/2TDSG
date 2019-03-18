package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
