package com.hm.commonsmiembros.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@MappedSuperclass
public class Ciudadano {
	
	@Pattern(regexp = "[a-z-A-Z]{1,50}", message = "'nombre' no cumple formato")
	protected String nombre;
	@Pattern(regexp = "[a-z-A-Z]{1,50}", message = "'apellido' no cumple formato")
	protected String apellido;
	@Past(message = "'fechaNacimiento' no cumple con el formato")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	protected Date fechaNacimiento;
	@Valid
	@ManyToOne
	@JoinColumn(name = "tipo_documento_id")
	protected TipoDocumento tipoDocumento;
	@Pattern(regexp = "[0-9]{1,15}", message = "'numeroDocumento' no cumple formato")
	@Column(name = "numero_documento")
	protected String numeroDocumento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date fechaRegistro;
	
	public Ciudadano() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

}
