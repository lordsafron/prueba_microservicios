package com.hm.commonsmiembros.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Entity
@Table(name = "log_traza")
public class LogTraza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String metodo;
	private String url;
	@Column(name = "cuerpo_peticion", length = 4000)
	private String cuerpoPeticion;
	@Column(name = "cuerpo_respuesta", length = 4000)
	private String cuerpoRespuesta;
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	public LogTraza() {
		
	}
	
	public LogTraza(String metodo, String url, String cuerpoPeticion, String cuerpoRespuesta) {
		super();
		this.metodo = metodo;
		this.url = url;
		this.cuerpoPeticion = cuerpoPeticion;
		this.cuerpoRespuesta = cuerpoRespuesta;
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

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCuerpoPeticion() {
		return cuerpoPeticion;
	}

	public void setCuerpoPeticion(String cuerpoPeticion) {
		this.cuerpoPeticion = cuerpoPeticion;
	}

	public String getCuerpoRespuesta() {
		return cuerpoRespuesta;
	}

	public void setCuerpoRespuesta(String cuerpoRespuesta) {
		this.cuerpoRespuesta = cuerpoRespuesta;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

}
