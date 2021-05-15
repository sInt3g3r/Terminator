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

    public List<Note> getNotes() {
        return noteRepo.findAll();
    }

//    public Optional<Note> getNote(long id) {
//        return Optional.ofNullable(noteRepo.findById(id));
//    }
}
