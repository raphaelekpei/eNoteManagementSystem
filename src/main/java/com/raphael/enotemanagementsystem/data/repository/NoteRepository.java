package com.raphael.enotemanagementsystem.data.repository;

import com.raphael.enotemanagementsystem.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

}
