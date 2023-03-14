/**
 * Esta clase representa una entidad (un registro) en la tabla de Vacantes de la base de datos
 */
package net.itinajero.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vacantes")
public class Vacante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;
	private String nombre; // Nombre de la oferta de trabajo.
	private String descripcion; // Descripcion corta de la oferta de trabajo
	private Date fecha; // Fecha de publicacion de la oferta del trabajo.
	private Double salario; // Salario aproximado que se ofrece por el trabajo.
	private String estatus; // Valores [Creado, Aprobado, Eliminado].
	private Integer destacado; // Valores [0, 1]. 0: No se muestra en la pag. principal | 1: Se muestra en la pagina principal.
	private String imagen="no-image.png"; // Nombre del archivo de la imagen del logotipo de la empresa que ofrece el trabajo.
	private String detalles; // Detalles de la oferta de trabajo.
	
	@OneToOne
	@JoinColumn(name = "idCategoria") // foreignKey en la tabla de Vacantes	
	private Categoria categoria; // Categoria a la que pertence la oferta de trabajo

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getDestacado() {
		return destacado;
	}

	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public void reset() {
		this.imagen=null;
	}

	@Override
	public String toString() {
		return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", salario=" + salario + ", estatus=" + estatus + ", destacado=" + destacado + ", imagen=" + imagen
				+ ", detalles=" + detalles + ", categoria=" + categoria + "]";
	}

}
