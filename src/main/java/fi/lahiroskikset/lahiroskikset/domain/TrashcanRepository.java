package fi.lahiroskikset.lahiroskikset.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrashcanRepository extends MongoRepository<Trashcan, String> {

}
