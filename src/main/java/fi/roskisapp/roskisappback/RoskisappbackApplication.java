package fi.roskisapp.roskisappback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.roskisapp.roskisappback.domain.Trashcan;
import fi.roskisapp.roskisappback.domain.TrashcanRepository;

@SpringBootApplication
public class RoskisappbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoskisappbackApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TrashcanRepository trashcanRepository) {
	return (args) -> {
		
		trashcanRepository.save(new Trashcan(11.11, 22.22));
		trashcanRepository.save(new Trashcan(33.33, 44.44));
		trashcanRepository.save(new Trashcan(55.55, 66.66));
		
	};

}

}
