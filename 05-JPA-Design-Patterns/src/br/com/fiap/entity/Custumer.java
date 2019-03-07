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
@Table(name = "T_CUSTUMER")
@SequenceGenerator(name="custumer", sequenceName="SQ_T_CUSTUMER", allocationSize = 1)
public class Custumer {
	
	@Id
	@Column(name="cd_custumer")
	@GeneratedValue(generator="custumer", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nm_custumer", nullable = false, length = 250 )
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_birthday")
	private Calendar birthday;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_gender")
	private Gender gander;
	
	@Lob
	@Column(name="fl_profileImage")
	private byte[] profileImage;
	
	public Custumer(int id, String name, Calendar birthday, Gender gander, byte[] profileImage) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.gander = gander;
		this.profileImage = profileImage;
	}

	public Custumer(String name, Calendar birthday, Gender gander, byte[] profileImage) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gander = gander;
		this.profileImage = profileImage;
	}

	public Custumer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Gender getGander() {
		return gander;
	}

	public void setGander(Gender gander) {
		this.gander = gander;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	
	
	
	

}
