package es.kami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class initController {

		@GetMapping("/")
		public String welcome() {
			return "project/index";
		}
		
		@GetMapping("/about")
		public String about() {
			return "project/about";
		}

}
