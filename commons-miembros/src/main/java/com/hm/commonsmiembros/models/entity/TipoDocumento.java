package com.hm.commonsmiembros.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Entity
@Table(name = "tipo_documentos")
public class TipoDocumento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private Integer id;
	@Pattern(regexp = "CI|P|CE", message = "'codigoTipoDocumento' no cumple formato")
	@Column(name = "codigo")
	private String codigoTipoDocumento;
	
	public TipoDocumento() {
		
	}

	public TipoDocumento(Integer id, String codigoTipoDocumento) {
		super();
		this.id = id;
		this.codigoTipoDocumento = codigoTipoDocumento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(String codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}
	
	
}
