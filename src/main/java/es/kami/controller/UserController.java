package es.kami.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.kami.entity.User;
import es.kami.repository.IUserRepository;

@Controller
class UserController{
	

		private final IUserRepository UserRepo;
	    public UserController(IUserRepository UserRepo) {
	        this.UserRepo = UserRepo;
	    }
	    // Ver todos los Usuarios
	    @GetMapping("/users")
	    public String showTypes(Map<String, Object> model) {
	        model.put("users", this.UserRepo.findAll());
	        return "users/usersList";
	    }
	    //Insertar nuevos usuarios
	    @RequestMapping(path = "/user/new", method = RequestMethod.GET)
		public String createType(Model model) {
			model.addAttribute("user", new User());
			return "project/register";
		}

		@RequestMapping(path = "user", method = RequestMethod.POST)
		public String saveType(User user) {
			UserRepo.save(user);
			return "redirect:/users";
		}
		// Actualizar Tipos
		
		//Borrar tipos
		
}
