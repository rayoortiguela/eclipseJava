/**
 * Esta clase representa una entidad (un registro) en la tabla de Solicitudes de la base de datos
 */
package net.itinajero.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Solicitudes")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;
	private LocalDate fecha; // Fecha en que aplico el usuario para esta oferta de trabajo
	private String comentarios;
	private String archivo; // El nombre del archivo PDF, DOCX del CV.

	@OneToOne
	@JoinColumn(name = "idVacante") // foreignKey en la tabla de solicitudes
	private Vacante vacante;

	@OneToOne
	@JoinColumn(name = "idUsuario") // foreignKey en la tabla de usuarios
	private Usuario usuario;

	public Solicitud() {
		this.fecha = LocalDate.now();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Vacante getVacante() {
		return vacante;
	}

	public void setVacante(Vacante vacante) {
		this.vacante = vacante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", fecha=" + fecha + ", comentarios=" + comentarios + ", archivo=" + archivo
				+ ", vacante=" + vacante + ", usuario=" + usuario + "]";
	}

}
