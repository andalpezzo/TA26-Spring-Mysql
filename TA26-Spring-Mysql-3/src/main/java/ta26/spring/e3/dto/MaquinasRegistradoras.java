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
@Table(name = "maquinas_registradoras") //en caso que la tabala sea diferente
public class MaquinasRegistradoras {

	//Atributos de entidad maquinas_registradoras
	@Id
	private long id;
	private int piso;
	
	@OneToMany
	@JoinColumn(name="id_maquina")
	private List<Venta> ventas;
	
	//Constructores
	public MaquinasRegistradoras() {
		
	}
	
	public MaquinasRegistradoras(long id, int piso, List<Venta> ventas) {
		super();
		this.id = id;
		this.piso = piso;
		this.ventas = ventas;
	}

	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ventas")
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "MaquinasRegistradoras [id=" + id + ", piso=" + piso + ", ventas=" + ventas + "]";
	}
	
}
