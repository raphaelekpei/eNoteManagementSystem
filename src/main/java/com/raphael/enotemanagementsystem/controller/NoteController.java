package com.raphael.enotemanagementsystem.controller;


import com.raphael.enotemanagementsystem.data.model.Note;
import com.raphael.enotemanagementsystem.dtos.request.AddNoteRequest;
import com.raphael.enotemanagementsystem.dtos.response.AddNoteResponse;

import java.util.List;

public interface NoteController {

    public AddNoteResponse addNotes(AddNoteRequest addNoteRequest);

    public Note viewNote(String id);

    public List<Note> viewAllNote();

    public String editNote(String id, String title, String description);

    public String deleteNote(String id);


}
