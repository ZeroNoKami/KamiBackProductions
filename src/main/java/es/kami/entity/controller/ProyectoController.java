package es.kami.entity.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.kami.entity.Proyectos;
import es.kami.repository.IProyectoRepository;

@Controller
class ProyectoController{

		private final IProyectoRepository proRepo;
	    public ProyectoController(IProyectoRepository proServ) {
	        this.proRepo = proServ;
	    }
	    
	    //Ver Proyectos
	    @GetMapping("/projects")
	    public String showProjects(Map<String, Object> model) {
	        model.put("projects", this.proRepo.findAll());
	        return "projects/projectList";
	    }
		
		// Actualizar Proyecto
		@RequestMapping(path = "/project/update/{id}", method = RequestMethod.GET)
	    public String editProject(Model model, @PathVariable(value = "id") Long id) {
	        model.addAttribute("project", proRepo.findById(id));
	        return "projects/addProjects";
	    }

		// Borrar un Proyecto
		@RequestMapping(value = "/project/erase/{id}", method = RequestMethod.GET)
		public String erasedProject(@PathVariable Long id) {
			this.proRepo.deleteById(id);
			return "redirect:/projects";
		}
		
	    //Insertar nuevos Proyectos
		@RequestMapping(path = "/project/new", method = RequestMethod.GET)
		public String createProject(Model model) {
			model.addAttribute("project", new Proyectos());
			return "projects/addProjects";
		}

		@RequestMapping(path = "project", method = RequestMethod.POST)
		public String save(Proyectos project) {
			proRepo.save(project);
			return "redirect:/projects";
		}
		
}
