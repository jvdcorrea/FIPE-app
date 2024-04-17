package br.jao.FIPEapp;


import br.jao.FIPEapp.main.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FipEappApplication {

	public static void main(String[] args) {SpringApplication.run(FipEappApplication.class, args);
		Menu menu = new Menu();
		menu.exibeMenu();
	}

	//@Override
//	public void run(String... args) throws Exception {
//		Menu menu = new Menu();
//		menu.exibeMenu();
//	}

}
