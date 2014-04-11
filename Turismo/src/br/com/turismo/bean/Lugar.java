package br.com.turismo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lugar")
public class Lugar {
	@Id
	@GeneratedValue
	private Long idCat;
	private String namePlace;
	private String description;
	private String address;
	private int categoria;

	public Long getIdCat() {
		return idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	public String getNamePlace() {
		return namePlace;
	}

	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
