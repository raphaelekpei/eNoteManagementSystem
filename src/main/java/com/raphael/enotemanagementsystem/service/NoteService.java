package com.raphael.enotemanagementsystem.service;

import com.raphael.enotemanagementsystem.data.model.Note;
import com.raphael.enotemanagementsystem.dtos.request.AddNoteRequest;
import com.raphael.enotemanagementsystem.dtos.response.AddNoteResponse;
import com.raphael.enotemanagementsystem.exceptions.NoteManagementException;

import java.util.List;

public interface NoteService {
    AddNoteResponse addNote(AddNoteRequest addNoteRequest);

    Note viewNote(String id) throws NoteManagementException;

    List<Note> viewAllNote();

    void editNote(String id, String title, String description);

    void deleteNote(String id);
}
