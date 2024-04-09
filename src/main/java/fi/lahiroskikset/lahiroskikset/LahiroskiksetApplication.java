package fi.lahiroskikset.lahiroskikset;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import fi.lahiroskikset.lahiroskikset.domain.Trashcan;
import fi.lahiroskikset.lahiroskikset.domain.TrashcanRepository;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableMongoRepositories
public class LahiroskiksetApplication {

	// private static final Logger log =
	// LoggerFactory.getLogger(RoskisappbackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LahiroskiksetApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TrashcanRepository trashcanRepository) {
		return (args) -> {

			// String coordsString = new String(
			// 		Files.readAllBytes(Paths.get("src\\main\\resources\\scripts\\coordinates.json")));
			// JSONArray jsonArray = new JSONArray(coordsString);
			// for (int i = 0; i < jsonArray.length(); i++) {
			// 	Double lat = jsonArray.getJSONObject(i).getDouble("lat");
			// 	Double lon = jsonArray.getJSONObject(i).getDouble("lon");
			// 	trashcanRepository.save(new Trashcan(lat, lon));
			// }
		};

	}

}
