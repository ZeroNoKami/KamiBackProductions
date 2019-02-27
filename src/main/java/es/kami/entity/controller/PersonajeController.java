package es.kami.entity.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.kami.entity.Personajes;
import es.kami.repository.ICiudadesRepository;
import es.kami.repository.IPersonajeRepository;
import es.kami.repository.IProyectoRepository;
import es.kami.repository.ITipoRepository;

@Controller
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
	@GetMapping("/charas")
	public String showCharList(Map<String, Object> model) {
		model.put("charas", this.JPAchara);
		return "chara/charasList";
	}
	// Borrar un personaje
	@RequestMapping(value = "/character/erase/{id_personaje}", method = RequestMethod.GET)
	public String erasedCharacter(@PathVariable Long id_personaje) {
		this.JPAchara.deleteById(id_personaje);
		return "redirect:/charas";
	}

	// Crear nuevo Personaje
	@RequestMapping(path = "/character/new", method = RequestMethod.GET)
	public String createCharacter(Model model, Map<String, Object> cities, Map<String, Object> types, Map<String, Object> pro) {
		model.addAttribute("character", new Personajes());
		cities.put("cityList", this.JPAcity.findAll());
		types.put("typeList", this.JPAtype.findAll());
		pro.put("projectList", this.JPApro.findAll());
		return "chara/addChara";
	}

	@RequestMapping(path = "character", method = RequestMethod.POST)
	public String saveCharacter(Personajes character) {
		JPAchara.save(character);
		return "redirect:/charas";
	}
	
	// Actualizar Personajes
	@RequestMapping(path = "/character/update/{id}", method = RequestMethod.GET)
    public String editCharacter(@PathVariable(value = "id") Long id, Model model, Map<String, Object> cities, Map<String, Object> types) {
		cities.put("cityList", this.JPAcity.findAll());
		types.put("typeList", this.JPAtype.findAll());
        model.addAttribute("character", JPAchara.findById(id));
        return "chara/addChara";
    }
	
	}