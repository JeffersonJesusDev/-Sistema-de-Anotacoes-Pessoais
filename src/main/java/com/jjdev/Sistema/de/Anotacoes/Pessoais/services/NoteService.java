package com.jjdev.Sistema.de.Anotacoes.Pessoais.services;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.Note;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NotesRepository data;

    public List<Note> getAll() {
        return data.findAll();
    }

    public Note saveNote(Note note) {
        return data.save(note);
    }

    public Note getNoteById(Long id) {
        Optional<Note> note = data.findById(id);
        return note.orElse(null);
    }

    public void deleteNoteById(Long id) {
        data.deleteById(id);
    }

    public Note updateNote(Long id, Note obj) {
        Note note = data.findById(id).get();
        note.setTitle(obj.getTitle());
        note.setContent(obj.getContent());
        note.setCategory(obj.getCategory());
        return data.save(note);
    }

}
