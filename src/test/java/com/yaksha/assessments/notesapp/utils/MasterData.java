package com.yaksha.assessments.notesapp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaksha.assessments.notesapp.entity.Note;

public class MasterData {
	public static Note getNote() {

		Note note = new Note();
		note.setId(1);
		note.setAuthor("Praveen");
		note.setTitle("Jenkins");
		note.setDescription("This is the best CI/CD tool");
		note.setStatus("Done");

		return note;
	}

	public static List<Note> getNoteList() {
		List<Note> notes = new ArrayList<>();
		Note note = new Note();
		note.setId(1);
		note.setAuthor("Praveen");
		note.setTitle("Jenkins");
		note.setDescription("This is the best CI/CD tool");
		note.setStatus("Done");
		notes.add(note);
		note = new Note();
		note.setId(2);
		note.setAuthor("Tylor");
		note.setTitle("Kubernetes");
		note.setDescription("This is best deployment tool");
		note.setStatus("Done");
		notes.add(note);
		return notes;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] toJson(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	public static Note createNote(Integer id, String author, String title, String status, String description) {
		Note note = new Note();
		note.setId(id);
		note.setAuthor(author);
		note.setDescription(description);
		note.setStatus(status);
		note.setTitle(title);
		return note;
	}

}
