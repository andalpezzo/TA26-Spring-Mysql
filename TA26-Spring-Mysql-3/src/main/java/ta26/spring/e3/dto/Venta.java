package ta26.spring.e3.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta") // en caso que la tabala sea diferente
public class Venta {

	// Atributos de entidad venta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cajero")
	private Cajeros cajero;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Productos producto;
	
	@ManyToOne
	@JoinColumn(name = "id_maquina")
	private MaquinasRegistradoras maquina;

	// Constructores
	public Venta() {

	}

	public Venta(int id, Cajeros cajero, Productos producto, MaquinasRegistradoras maquina) {
		super();
		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquina = maquina;
	}

	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cajeros getCajero() {
		return cajero;
	}

	public void setCajero(Cajeros cajero) {
		this.cajero = cajero;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public MaquinasRegistradoras getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinasRegistradoras maquina) {
		this.maquina = maquina;
	}
	
	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", producto=" + producto + ", maquina=" + maquina + "]";
	}
}
