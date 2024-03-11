package fi.lahiroskikset.lahiroskikset.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fi.lahiroskikset.lahiroskikset.domain.Trashcan;
import fi.lahiroskikset.lahiroskikset.domain.TrashcanRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@RestController
public class TrashcanRestController {
    @Autowired
    private TrashcanRepository trashcanRepository;

    @GetMapping("/api/trashcans")
    public @ResponseBody List<Trashcan> listAllTrashcansREST() {
        return (List<Trashcan>) trashcanRepository.findAll();
    }

}