package com.jjdev.Sistema.de.Anotacoes.Pessoais.DTO;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.Note;

import java.util.Date;

public record NoteDTO(Long id, String title, String content, String category) {

    public NoteDTO(Note note) {
        this (note.getId(), note.getTitle(), note.getContent(),  note.getCategory());
    }
}
