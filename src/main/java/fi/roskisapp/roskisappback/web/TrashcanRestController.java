package fi.roskisapp.roskisappback.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fi.roskisapp.roskisappback.domain.Trashcan;
import fi.roskisapp.roskisappback.domain.TrashcanRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class TrashcanRestController {
    @Autowired
    private TrashcanRepository trashcanRepository;

    @GetMapping("/api/trashcans")
    public @ResponseBody List<Trashcan> listAllTrashcansREST() {
        return (List<Trashcan>) trashcanRepository.findAll();
    }

}
