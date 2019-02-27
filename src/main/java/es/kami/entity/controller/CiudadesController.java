package es.kami.entity.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.kami.entity.Ciudades;
import es.kami.repository.ICiudadesRepository;

@Controller
class CiudadesController{

		private final ICiudadesRepository cityRepo;
	    public CiudadesController(ICiudadesRepository ciuServ) {
	        this.cityRepo = ciuServ;
	    }
	    //Ver Ciudades
	    @GetMapping("/cities")
	    public String showCities(Map<String, Object> model) {
	        model.put("cities", this.cityRepo.findAll());
	        return "cities/citiesList";
	    }

		
		// Actualizar Ciudades
		@RequestMapping(path = "/city/update/{id}", method = RequestMethod.GET)
	    public String editCity(Model model, @PathVariable(value = "id") Long id) {
	        model.addAttribute("city", cityRepo.findById(id));
	        return "cities/addCity";
	    }

		// Borrar una ciudad
		@RequestMapping(value = "/city/erase/{id}", method = RequestMethod.GET)
		public String erasedCity(@PathVariable Long id) {
			this.cityRepo.deleteById(id);
			return "redirect:/cities";
		}
		
		// Crear nueva Ciudad
		@RequestMapping(path = "/city/new", method = RequestMethod.GET)
		public String createCity(Model model) {
			model.addAttribute("city", new Ciudades());
			return "cities/addCity";
		}

		@RequestMapping(path = "city", method = RequestMethod.POST)
		public String saveCity(Ciudades city) {
			cityRepo.save(city);
			return "redirect:/cities";
		}
}
