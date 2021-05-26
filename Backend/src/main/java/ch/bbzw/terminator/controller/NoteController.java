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

    //readAll
    @GetMapping(path = "getNotes")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    //readSingle
    @GetMapping(path = "getNote/{id}")
    public Optional<Note> getNote(@PathVariable("id") long id) { return noteService.getNote(id);}

    //delete
    @DeleteMapping(path = "delNote/{id}")
    public void delNote(@PathVariable("id") long id) { noteService.delNote(id);}

    //replace
    @PutMapping(path = "putNote/{id}")
    public void putNote(@PathVariable("id") long id, @RequestBody Note note) { noteService.putNote(id,note);}

    //create
    @PostMapping(path = "postNote")
    public void postNote(@RequestBody Note note) { noteService.postNote(note);}
}
