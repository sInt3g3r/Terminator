package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.Note;
import ch.bbzw.terminator.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(path = "getNotes")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }
}
