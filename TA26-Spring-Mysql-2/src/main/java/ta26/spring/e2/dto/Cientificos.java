package ta26.spring.e2.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cientificos")//en caso que la tabala sea diferente
public class Cientificos {

	//Atributos de entidad cientificos
	@Id
	@Column(name = "dni")
	private String dni;
	@Column(name = "nomapels")
	private String nomapels;
	
	@OneToMany
    @JoinColumn(name="id_cientifico")
    private List<AsignadoA> asignado_a;
	
	//Constructores
	public Cientificos() {
	
	}

	public Cientificos(String id, String nombre, List<AsignadoA> suministra) {
		this.dni = id;
		this.nomapels = nombre;
		this.asignado_a = suministra;
	}

	// Getters and setters
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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignadoA() {
		return asignado_a;
	}
	
	public void setAsignado_a(List<AsignadoA> asignado_a) {
		this.asignado_a = asignado_a;
	}

	@Override
	public String toString() {
		return "Piezas [codigo=" + dni + ", nombre=" + nomapels + ", suministra=" + asignado_a + "]";
	}
	
}