package org.authentication.repositories;

import org.authentication.entities.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends MongoRepository<Sequence, String> {
    Sequence findByName(String name); // Find a sequence by its username
}
