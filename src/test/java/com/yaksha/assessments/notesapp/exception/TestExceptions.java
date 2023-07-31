package com.yaksha.assessments.notesapp.exception;

import static com.yaksha.assessments.notesapp.utils.TestUtils.currentTest;
import static com.yaksha.assessments.notesapp.utils.TestUtils.exceptionTestFile;
import static com.yaksha.assessments.notesapp.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assessments.notesapp.controller.NoteController;
import com.yaksha.assessments.notesapp.service.NoteService;

@WebMvcTest(NoteController.class)
@AutoConfigureMockMvc
public class TestExceptions {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NoteService noteService;

	// Exception
	@Test
	public void testDataValidationCheckIsAddedInController() throws Exception {

		yakshaAssert(currentTest(), true, exceptionTestFile);
	}

}
