package ta26.spring.e2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignado_a") // en caso que la tabala sea diferente
public class AsignadoA {

	// Atributos de entidad asignado_a
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_cientifico")
	private Cientificos cientifico;

	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyectos proyecto;

	// Constructores
	public AsignadoA() {

	}

	public AsignadoA(int id, Cientificos cientifico, Proyectos proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cientificos getCientifico() {
		return cientifico;
	}

	public void setCientifico(Cientificos cientifico) {
		this.cientifico = cientifico;
	}

	public Proyectos getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}
	
	@Override
	public String toString() {
		return "AsignadoA [id=" + id + ", cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}
}
