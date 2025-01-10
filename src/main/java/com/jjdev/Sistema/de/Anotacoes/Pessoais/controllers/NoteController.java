package com.jjdev.Sistema.de.Anotacoes.Pessoais.controllers;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.Note;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    private NotesRepository notesRepository;

    @GetMapping
    public ResponseEntity<List> getAllNotes(){
        List<Note> notes = notesRepository.findAll();
        return ResponseEntity.ok().body(notes);
    }
}
