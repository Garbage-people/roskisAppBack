package fi.lahiroskikset.lahiroskikset.web;

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
        return (List<Trashcan>) trashcanRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTrashcan(@PathVariable("id") String id, @RequestBody Trashcan updatedTrashcan) {
        try {
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
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> addTrashcan(@RequestBody Trashcan newTrashcan) {
        // Fetch all trashcans from the database and calculate distance between existing trashcans and the new trashcan.
        // Reject the new trashcan if it's too close to an existing one.

        List<Trashcan> trashcans = trashcanRepository.findAll();

        for (Trashcan trashcan : trashcans) {
            if (DistanceCalculator.calculateDistance(newTrashcan, trashcan) < 0.00015) {
                // 0.00015 is empirically found numerical distance we've deemed too close
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
        }
        trashcanRepository.save(newTrashcan);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
