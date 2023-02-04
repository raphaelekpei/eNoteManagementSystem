package com.raphael.enotemanagementsystem.controller;

import com.raphael.enotemanagementsystem.data.model.Note;
import com.raphael.enotemanagementsystem.dtos.request.AddNoteRequest;
import com.raphael.enotemanagementsystem.dtos.response.AddNoteResponse;
import com.raphael.enotemanagementsystem.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/note")
@RestController
public class NoteControllerImpl implements NoteController{

    @Autowired
    private final NoteService noteService;

    @Override
    @PostMapping("/add")
    public AddNoteResponse addNotes(@RequestBody AddNoteRequest addNoteRequest) {
        return noteService.addNote(addNoteRequest);
    }

    @Override
    @GetMapping("/view/{id}")
    public Note viewNote(@PathVariable String id) {
        return noteService.viewNote(id);
    }

    @Override
    @GetMapping("/all")
    public List<Note> viewAllNote() {
        return noteService.viewAllNote();
    }

    @Override
    @PutMapping("/update{id}")
    public String editNote(
            @PathVariable String id,
            @RequestParam String title,
            @RequestParam String description) {
        noteService.editNote(id, title, description);
        return "edited successfully";
    }

    @Override
    public String deleteNote(String id) {
        noteService.deleteNote(id);
        return "deleted successfully";
    }

}
