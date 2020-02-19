package com.hm.microserviciopersonas.app.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.hm.commonsmiembros.models.entity.Ciudadano;
import com.hm.commonsmiembros.models.entity.Miembro;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Entity
@Table(name = "personas")
public class Persona extends Ciudadano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email(message = "'email' no cumple con el formato")
	private String email;//^[a-zA-Z\\s\\u00F1\\u00D1áéíóúÁÉÍÓÚ]*${1,50}+
	@Pattern(regexp = "^[a-zA-Z\\s\\u00F1\\u00D1áéíóúÁÉÍÓÚ]*${1,100}+", message = "'direccion' no cumple formato")
	private String direccion;
	@Pattern(regexp = "^[a-zA-Z\\s\\u00F1\\u00D1áéíóúÁÉÍÓÚ]*${1,50}+", message = "'profesion' no cumple formato")
	private String profesion;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Miembro> miembros;
	
	public Persona() {
		this.miembros = new ArrayList<>();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public List<Miembro> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<Miembro> miembros) {
		this.miembros = miembros;
	}
	
	public void addMiembro(Miembro miembro) {
		this.miembros.add(miembro);
	}
	
	public void removeMiembro(Miembro miembro) {
		this.miembros.remove(miembro);
	}
	

}
