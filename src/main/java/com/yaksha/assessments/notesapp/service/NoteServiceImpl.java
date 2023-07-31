package com.yaksha.assessments.notesapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaksha.assessments.notesapp.entity.Note;
import com.yaksha.assessments.notesapp.repository.NoteRepository;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note addNote(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note deleteNote(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note updateNote(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
