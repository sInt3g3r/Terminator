package ch.bbzw.terminator.repository;

import ch.bbzw.terminator.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note,Long> {
}
