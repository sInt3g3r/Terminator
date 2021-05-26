package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.Note;
import ch.bbzw.terminator.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(path = "getNotes") //readAll
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping(path = "getNote/{id}") //readSingle
    public Optional<Note> getNote(@PathVariable("id") long id) { return noteService.getNote(id);}

    @DeleteMapping(path = "delNote/{id}") //delete
    public void delNote(@PathVariable("id") long id) { noteService.delNote(id);}

    @PutMapping(path = "putNote/{id}") //replace
    public void putNote(@PathVariable("id") long id, @RequestBody Note note) { noteService.putNote(id,note);}

    @PostMapping(path = "postNote") //create
    public void postNote(@RequestBody Note note) { noteService.postNote(note);}
}
