package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tn.esprit.Controller.UserController;
import tn.esprit.entities.checkDTO;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"tn.esprit.dto"})
@ComponentScan(basePackageClasses = {UserController.class, checkDTO.class})

public class PidevApplication {

	public static void main(String[] args) {
		SpringApplication.run(PidevApplication.class, args);
	}

}
