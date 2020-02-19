package com.hm.commonsmiembros.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Entity
@Table(name = "miembros")
public class Miembro extends Ciudadano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Pattern(regexp = "[a-zA-Z]{1,50}+", message = "'parentesco' no cumple formato")
	private String parentesco;
	
	public Miembro() {
		
	}
	
	@PrePersist
	public void prePersist() {
		this.fechaRegistro = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Miembro)) {
			return false;
		}
		
		Miembro a = (Miembro) obj;
		
		return this.id != null && this.id.equals(a.getId());
	}

}
