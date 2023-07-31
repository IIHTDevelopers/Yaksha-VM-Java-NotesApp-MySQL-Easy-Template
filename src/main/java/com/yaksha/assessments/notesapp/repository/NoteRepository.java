package com.yaksha.assessments.notesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaksha.assessments.notesapp.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

}
