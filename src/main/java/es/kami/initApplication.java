package es.kami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class initApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(initApplication.class, args);
	}
}

