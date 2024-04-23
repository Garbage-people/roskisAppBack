package fi.lahiroskikset.lahiroskikset.web;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fi.lahiroskikset.lahiroskikset.domain.Trashcan;
import fi.lahiroskikset.lahiroskikset.domain.TrashcanRepository;
import fi.lahiroskikset.lahiroskikset.service.DistanceCalculator;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/trashcans")
public class TrashcanRestController {
    @Autowired
    private TrashcanRepository trashcanRepository;

    @GetMapping
    public @ResponseBody List<Trashcan> listAllTrashcansREST() {
        String apiKeyName = "API_KEY";

        String apiValue = System.getenv(apiKeyName);

        if (apiValue != null) {
            System.out.println("Environment variable '" + apiKeyName + "' exists.");
            System.out.println("Value: " + apiValue);
        } else {
            System.out.println("Environment variable '" + apiKeyName + "' does not exist.");
        }

        return (List<Trashcan>) trashcanRepository.findAll();
    };

    private boolean isValidStatus(String status) {
        return Arrays.asList("0", "1", "2").contains(status);
    };

    private boolean isValidDateTime(String dateTimeString) {
        try {
            LocalDateTime currentDateTime = LocalDateTime.now(ZoneOffset.UTC);
            LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_DATE_TIME);

            long diff = ChronoUnit.HOURS.between(parsedDateTime, currentDateTime);

            if (diff == 0) {
                return true;
            } else {
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
    };

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTrashcan(@PathVariable("id") String id, @RequestBody Trashcan updatedTrashcan) {
        try {

            if (!isValidStatus(updatedTrashcan.getStatus()[0])) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            };

            if (!isValidDateTime(updatedTrashcan.getStatus()[1])) {
                return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
            };

            Optional<Trashcan> trashcanToUpdate = trashcanRepository.findById(id);
            if (trashcanToUpdate.isPresent()) {
                trashcanToUpdate.get().setStatus(updatedTrashcan.getStatus()[0], updatedTrashcan.getStatus()[1]);
                trashcanRepository.save(trashcanToUpdate.get());
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
        } catch (Error e) {
            System.err.println(e);
        };
        return null;
    };

    @PostMapping
    public ResponseEntity<Void> addTrashcan(@RequestBody Trashcan newTrashcan) {
        // Fetch all trashcans from the database and calculate distance between existing
        // trashcans and the new trashcan.
        // Reject the new trashcan if it's too close to an existing one.

        List<Trashcan> trashcans = trashcanRepository.findAll();
        try {
            for (Trashcan trashcan : trashcans) {
                if (DistanceCalculator.calculateDistance(newTrashcan, trashcan) < 0.00015) {
                    // 0.00015 is empirically found numerical distance we've deemed too close
                    return new ResponseEntity<Void>(HttpStatus.I_AM_A_TEAPOT);
                }
                ;
            }
            ;
            trashcanRepository.save(newTrashcan);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    };
};
