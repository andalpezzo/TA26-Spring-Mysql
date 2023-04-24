package ta26.spring.e4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {

	@Id
	private int id;
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_facultad")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name="id_equipo")
	private List<Reserva> reservas;

	public Equipos() {

	}

	//Constructores
	public Equipos(int id, String nombre, Facultad facultad, List<Reserva> reservas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY)
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Equipos [num_serie=" + id + ", nombre=" + nombre + ", facultad=" + facultad + ", reservas="
				+ reservas + "]";
	}

}
