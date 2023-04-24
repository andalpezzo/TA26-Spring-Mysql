package ta26.spring.e3.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cajeros") //en caso que la tabala sea diferente
public class Cajeros {

	//Atributos de entidad cajeros
	@Id
	private int id;
	private String nomapels;
	
	@OneToMany
	@JoinColumn(name="id_cajero")
    private List<Venta> ventas;
	
	//Constructores
	public Cajeros() {
	
	}

	public Cajeros(int id, String nombre, List<Venta> suministra) {
		this.id = id;
		this.nomapels = nombre;
		this.ventas = suministra;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ventas")
	public List<Venta> getAsignadoA() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Piezas [codigo=" + id + ", nombre=" + nomapels + ", suministra=" + ventas + "]";
	}
	
}