package com.yaksha.assessments.notesapp.service;

import java.util.List;

import com.yaksha.assessments.notesapp.entity.Note;

public interface NoteService {
	public List<Note> findAll();

	public Note findById(Integer id);

	public Note addNote(Note note);

	public Note deleteNote(Integer id);

	public Note updateNote(Note note);
}
