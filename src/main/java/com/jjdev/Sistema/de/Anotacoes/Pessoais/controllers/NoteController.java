package com.jjdev.Sistema.de.Anotacoes.Pessoais.controllers;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.DTO.NoteDTO;
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
    public ResponseEntity<List<NoteDTO>> getAllNotes(){
        List<Note> notes = noteService.getAll();
        List<NoteDTO> notesDTO = notes.stream()
                .map(NoteDTO::new)
                .toList();
        return ResponseEntity.ok().body(notesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(Long id){
        Note note = noteService.getNoteById(id);
        NoteDTO noteDTO = new NoteDTO(note);
        return ResponseEntity.ok().body(noteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id){
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<NoteDTO> updateNote(@RequestBody Note obj, @PathVariable Long id){
        obj = noteService.updateNote(id, obj);
        NoteDTO noteDTO = new NoteDTO(obj);
        return ResponseEntity.ok().body(noteDTO);
    }

}
