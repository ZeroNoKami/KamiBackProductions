package es.kami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class registerController {

		@GetMapping("/register")
		public String welcome() {
			return "project/register";
		}
		

}

