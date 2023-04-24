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
@Table(name = "investigadores")
public class Investigadores {

	@Id
	private String dni;
	private String nomapels;

	@ManyToOne
	@JoinColumn(name = "id_facultad")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name = "id_investigador")
	private List<Reserva> reservas;

	//Constructores
	public Investigadores() {

	}

	public Investigadores(String dni, String nomapels, Facultad facultad, List<Reserva> reservas) {
		super();
		this.dni = dni;
		this.nomapels = nomapels;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	//Getters and setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "investigadores", fetch = FetchType.LAZY)
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigadores [dni=" + dni + ", nomapels=" + nomapels + ", facultad=" + facultad + ", reservas="
				+ reservas + "]";
	}

}
