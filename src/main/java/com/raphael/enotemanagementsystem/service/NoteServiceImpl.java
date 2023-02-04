package com.raphael.enotemanagementsystem.service;

import com.raphael.enotemanagementsystem.data.model.Note;
import com.raphael.enotemanagementsystem.data.repository.NoteRepository;
import com.raphael.enotemanagementsystem.dtos.request.AddNoteRequest;
import com.raphael.enotemanagementsystem.dtos.response.AddNoteResponse;
import com.raphael.enotemanagementsystem.exceptions.NoteManagementException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{

    @Autowired
    private final NoteRepository noteRepository;
    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        Note note = new Note(
                addNoteRequest.getTitle(),
                addNoteRequest.getDescription()
        );
        noteRepository.save(note);
        AddNoteResponse addNoteResponse = new AddNoteResponse();
        addNoteResponse.setMessage("added successfully");
        return addNoteResponse;
    }

    @Override
    public Note viewNote(String id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
            throw new NoteManagementException("note does not exist");
        }
        return optionalNote.get();
    }

    @Override
    public List<Note> viewAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public void editNote(String id, String title, String description) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()){
            throw new NoteManagementException("note does not exist");
        }
        Note note = optionalNote.get();
        if (title != null){
            note.setTitle(title);
        }
        if (description != null){
            note.setDescription(description);
        }
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(String id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()){
            throw new NoteManagementException("note not found");
        }
        Note note = optionalNote.get();
        noteRepository.delete(note); ;
    }
}
