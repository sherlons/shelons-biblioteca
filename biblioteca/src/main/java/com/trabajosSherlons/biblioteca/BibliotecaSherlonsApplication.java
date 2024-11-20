package com.trabajosSherlons.biblioteca;

import com.trabajosSherlons.biblioteca.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaSherlonsApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.
				run(BibliotecaSherlonsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal= new Principal();
		principal.menuIncio();

	}

}
