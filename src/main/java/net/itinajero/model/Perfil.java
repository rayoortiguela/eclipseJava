
/**
 * Esta clase representa una entidad (un registro) en la tabla de Perfiles de la base de datos
 */
package net.itinajero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Perfiles")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;
	private String perfil;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", perfil=" + perfil + "]";
	}

}
