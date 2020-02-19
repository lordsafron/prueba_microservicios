package com.hm.commonsmiembros.models.entity;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
public enum TipoDocumentoEnum {
	
	CEDULA(1, "CI"),
	PASAPORTE(2, "P"),
	CEDULA_EXTRANJERIA(3, "CE");
	
	private Integer id;
	private String codigo;
	
	private TipoDocumentoEnum(Integer id, String codigo) {
		this.id = id;
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
