package fi.lahiroskikset.lahiroskikset.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fi.lahiroskikset.lahiroskikset.domain.Trashcan;
import fi.lahiroskikset.lahiroskikset.domain.TrashcanRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
