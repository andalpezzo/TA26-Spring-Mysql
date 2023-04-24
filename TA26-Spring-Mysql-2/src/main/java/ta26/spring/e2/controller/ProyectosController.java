package ta26.spring.e2.controller;

import ta26.spring.e2.dto.Proyectos;
import ta26.spring.e2.service.ProyectosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProyectosController {
	
	@Autowired
	ProyectosService proyectoService;
	
	@GetMapping("/proyectos")
	public List<Proyectos> listarProyectos(){
		return proyectoService.listarProyectos();
	}
	
	
	@PostMapping("/proyectos")
	public Proyectos salvarProyecto(@RequestBody Proyectos proyecto) {
		
		return proyectoService.guardarProyecto(proyecto);
	}
	
	
	@GetMapping("/proyectos/{id}")
	public Proyectos proyectoXID(@PathVariable(name="id") int id) {
		
		Proyectos proyecto_xid= new Proyectos();
		
		proyecto_xid=proyectoService.proyectoXID(id);
		
		System.out.println("Curso XID: "+proyecto_xid);
		
		return proyecto_xid;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyectos actualizarProyecto(@PathVariable(name="id")int id,@RequestBody Proyectos proyecto) {
		
		Proyectos proyecto_seleccionado= new Proyectos();
		Proyectos proyecto_actualizado= new Proyectos();
		
		proyecto_seleccionado= proyectoService.proyectoXID(id);
		
		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setHoras(proyecto.getHoras());
		
		proyecto_actualizado = proyectoService.actualizarProyecto(proyecto_seleccionado);
		
		System.out.println("El proyecto actualizado es: "+ proyecto_actualizado);
		
		return proyecto_actualizado;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name="id")int id) {
		proyectoService.eliminarProyecto(id);
	}
}
