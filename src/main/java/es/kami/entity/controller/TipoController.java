package es.kami.entity.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.kami.entity.Tipo;
import es.kami.repository.ITipoRepository;

@Controller
class TipoController{
	

		private final ITipoRepository tipoRepo;
	    public TipoController(ITipoRepository tipoServ) {
	        this.tipoRepo = tipoServ;
	    }
	    // Ver todos los Tipos
	    @GetMapping("/types")
	    public String showTypes(Map<String, Object> model) {
	        model.put("types", this.tipoRepo.findAll());
	        return "types/typeList";
	    }
	
	    //Insertar nuevos tipos
		@RequestMapping(path = "/type/new", method = RequestMethod.GET)
		public String createType(Model model) {
			model.addAttribute("type", new Tipo());
			return "types/addType";
		}

		@RequestMapping(path = "type", method = RequestMethod.POST)
		public String saveType(Tipo type) {
			tipoRepo.save(type);
			return "redirect:/types";
		}
		// Actualizar Tipos
		@RequestMapping(path = "/type/update/{id}", method = RequestMethod.GET)
	    public String editType(Model model, @PathVariable(value = "id") Long id) {
	        model.addAttribute("type", tipoRepo.findById(id));
	        return "types/addType";
	    }
		//Borrar tipos
		@RequestMapping(value = "/type/erase/{id}", method = RequestMethod.GET)
		public String erasedType(@PathVariable Long id) {
			this.tipoRepo.deleteById(id);
			return "redirect:/types";
		}
}
