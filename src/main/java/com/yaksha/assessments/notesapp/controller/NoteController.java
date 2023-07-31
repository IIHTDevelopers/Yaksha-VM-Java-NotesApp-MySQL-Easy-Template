package com.yaksha.assessments.notesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.notesapp.service.NoteService;
@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	
	
}











