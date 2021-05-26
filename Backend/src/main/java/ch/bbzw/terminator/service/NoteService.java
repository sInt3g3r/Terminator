package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Note;
import ch.bbzw.terminator.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    //readAll
    public List<Note> getNotes() {
        return noteRepo.findAll();
    }

    //readSingle
    public Optional<Note> getNote(long id) {
        boolean exists = noteRepo.existsById(id);
        if (exists) {
            return noteRepo.findById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //delete
    public void delNote(Long id) {
        boolean exists = noteRepo.existsById(id);
        if (exists) {
            noteRepo.deleteById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //replace
    public void putNote(Long id, Note note) {
        boolean exists = noteRepo.existsById(id);
        if (exists) {
            note.setId(id);
            noteRepo.save(note);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //create
    public void postNote(Note note) {
        if (note.getNote().isEmpty() || note.getUserId() <= 0) {
            throw new IllegalStateException("Note cannot be empty. UserId needs to be greater then 0.");
        }
        else{
            noteRepo.save(note);
        }
    }
}
