package ta26.spring.e2.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos") // en caso que la tabala sea diferente
public class Proyectos {

	// Atributos de entidad proyecto
	@Id
	private int id;
	private String nombre;
	private int horas;

	@OneToMany
	@JoinColumn(name = "id_proyecto")
	private List<AsignadoA> asignado_a;

	// Constructores

	public Proyectos() {

	}

	public Proyectos(int id, String nombre, int horas, List<AsignadoA> suministra) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.asignado_a = suministra;
	}
	
	// Getters and setters
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignaA")
	public List<AsignadoA> getAsignaA() {
		return asignado_a;
	}

	public void setAsignado_a(List<AsignadoA> asignado_a) {
		this.asignado_a = asignado_a;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", asignado_a=" + asignado_a + "]";
	}

}
