package com.jjdev.Sistema.de.Anotacoes.Pessoais.controllers;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.Note;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List> getAllNotes(){
        List<Note> notes = noteService.getAll();
        return ResponseEntity.ok().body(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(Long id){
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok().body(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id){
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note obj, @PathVariable Long id){
        obj = noteService.updateNote(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
