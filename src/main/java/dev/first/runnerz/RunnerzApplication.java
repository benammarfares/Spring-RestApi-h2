package dev.first.runnerz;

import dev.first.runnerz.cardio.Cardio;
import dev.first.runnerz.cardio.Equipment;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunnerzApplication {
	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);
	public static void main(String[] args) {
	SpringApplication.run(RunnerzApplication.class, args);
	}

 @Bean
	CommandLineRunner run(){
		return args -> {
          Cardio cardio = new Cardio(1,"Running", "Running is a great way to get in shape and lose weight. It can improve your health and mental well-being. It can also help you lose weight and improve your cardiovascular health.", Equipment.BARBELL, "Legs", "Beginner", "Cardio");
  		  log .info("Cardio:"+ cardio);
		};
	}
}
