
package ta26.spring.e4.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime comienzo;
    private LocalDateTime fin;

    @ManyToOne
    @JoinColumn(name = "id_investigadores")
    private Investigadores investigador;

    @ManyToOne
    @JoinColumn(name = "id_equipos")
    private Equipos equipo;
	
    //Constructores
    public Reserva() {
	
    }
    
	public Reserva(int id, LocalDateTime comienzo, LocalDateTime fin, Investigadores investigador, Equipos equipo) {
		super();
		this.id = id;
		this.comienzo = comienzo;
		this.fin = fin;
		this.investigador = investigador;
		this.equipo = equipo;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getComienzo() {
		return comienzo;
	}

	public void setComienzo(LocalDateTime comienzo) {
		this.comienzo = comienzo;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public Investigadores getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigadores investigador) {
		this.investigador = investigador;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", investigador=" + investigador
				+ ", equipo=" + equipo + "]";
	}
    
}
