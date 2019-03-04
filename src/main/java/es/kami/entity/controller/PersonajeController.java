package es.kami.entity.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.kami.entity.Personajes;
import es.kami.repository.ICiudadesRepository;
import es.kami.repository.IPersonajeRepository;
import es.kami.repository.IProyectoRepository;
import es.kami.repository.ITipoRepository;
import es.kami.utils.Constantes;

@RestController
@RequestMapping("/character")
class PersonajeController {

	private final IPersonajeRepository JPAchara;
	private final ICiudadesRepository JPAcity;
	private final ITipoRepository JPAtype;
	private final IProyectoRepository JPApro;
	
	public PersonajeController(IPersonajeRepository charServ, 
							   ICiudadesRepository cityServ, 
							   ITipoRepository typeServ,
							   IProyectoRepository proServ) {
		this.JPAchara = charServ;
		this.JPAcity = cityServ;
		this.JPAtype = typeServ;
		this.JPApro = proServ;

	}
	
	// Lista de Personajes
	@PreAuthorize(Constantes.USER_ALLOW_ALL_REG)
	@GetMapping("/list")
	public List<Personajes> showCharList() {
		return this.JPAchara.findAll();
	}
	
	//Buscar un personaje 
	@PreAuthorize(Constantes.USER_ALLOW_ALL_REG)
	@GetMapping("/view/{id_personaje}")
	public Optional<Personajes> showCharList(@PathVariable Long id_personaje) {
		return this.JPAchara.findById(id_personaje);
	}
	
	// Borrar un personaje
	@PreAuthorize(Constantes.USER_ALLOW_ADMIN)
	@DeleteMapping(value = "/erase/{id_personaje}")
	public ResponseEntity<?> erasedCharacter(@PathVariable Long id_personaje) {
		Optional<Personajes> persona = JPAchara.findById(id_personaje);
		
		if(persona.isPresent()) {
			JPAchara.delete(persona.get());
			return new ResponseEntity<Personajes>(persona.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("El empleado no existe", HttpStatus.NOT_FOUND);
		}
	}
	
	// Crear nuevo Personaje
	@PreAuthorize(Constantes.USER_ALLOW_ALL_REG)
	@PostMapping(path = "/new")
	public Personajes createCharacter(@RequestBody Personajes personaBody, HttpServletResponse response, Model model, Map<String, Object> cities, Map<String, Object> types, Map<String, Object> pro) {
		Personajes persona = personaBody;
		response.setStatus(201);
		return JPAchara.save(persona);
	}
	
	// Actualizar Personajes
	@PreAuthorize(Constantes.USER_ALLOW_ADMIN)
	@PutMapping(path = "/update/{id}")
	   public ResponseEntity<?> editCharacter(@PathVariable(value = "id") Long id, RequestEntity<Personajes> reqPersonajes) {
			if(reqPersonajes.getBody() == null) {
			return new ResponseEntity<String>("mal", HttpStatus.BAD_REQUEST);
		}
		
		if(JPAchara.findById(id).isPresent()) {
			Personajes persona = reqPersonajes.getBody();
			Personajes newPersona = new Personajes(id, persona);
			return new ResponseEntity<Personajes>(JPAchara.save(newPersona), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NOT FOUND", HttpStatus.NOT_FOUND); 
		}
    }	
}