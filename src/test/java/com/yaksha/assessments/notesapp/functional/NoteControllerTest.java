package com.yaksha.assessments.notesapp.functional;

import static com.yaksha.assessments.notesapp.utils.TestUtils.asJsonString;
import static com.yaksha.assessments.notesapp.utils.TestUtils.businessTestFile;
import static com.yaksha.assessments.notesapp.utils.TestUtils.currentTest;
import static com.yaksha.assessments.notesapp.utils.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yaksha.assessments.notesapp.controller.NoteController;
import com.yaksha.assessments.notesapp.entity.Note;
import com.yaksha.assessments.notesapp.service.NoteService;
import com.yaksha.assessments.notesapp.utils.MasterData;

@WebMvcTest(NoteController.class)
@AutoConfigureMockMvc
class NoteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private NoteService noteService;

	/************* Get All Notes *******************/

	@Test
	void testRestEndpointForFindAllNotesIsExposedAndWorking() throws Exception {
		List<Note> list = new ArrayList<Note>();
		list.add(MasterData.getNote());
		Mockito.when(noteService.findAll()).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/all")
				.content(MasterData.asJsonString(MasterData.getNote())).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list)) ? "true" : "false"),
				businessTestFile);

	}

	@Test
	void testAbleToDefineAppropriateClassesAndObjectsForAGivenScenario() throws Exception {
		List<Note> list = new ArrayList<Note>();
		list.add(MasterData.getNote());
		Mockito.when(noteService.findAll()).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/all")
				.content(MasterData.asJsonString(MasterData.getNote())).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list)) ? "true" : "false"),
				businessTestFile);

	}

	@Test
	void testAbleToConfigureAndConnectToDatabase() throws Exception {
		List<Note> list = new ArrayList<Note>();
		list.add(MasterData.getNote());
		Mockito.when(noteService.findAll()).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/all")
				.content(MasterData.asJsonString(MasterData.getNote())).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list)) ? "true" : "false"),
				businessTestFile);

	}

	@Test
	void testRestEndpointForFindAllNotesIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
		final int count[] = new int[1];
		List<Note> list = new ArrayList<Note>();
		list.add(MasterData.getNote());
		Mockito.when(noteService.findAll()).then(new Answer<List<Note>>() {

			@Override
			public List<Note> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub

				count[0]++;
				return list;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/all")
				.content(MasterData.asJsonString(MasterData.getNote())).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	/*************** Add Note ***********************/

	@Test
	void testRestEndpointForAddNewNoteIsExposedAndWorking() throws Exception {
		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		Mockito.when(noteService.addNote(Note)).thenReturn(Note);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/noteservice/add")
				.content(com.yaksha.assessments.notesapp.utils.MasterData.asJsonString(Note))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(Note)) ? true : false,
				businessTestFile);

	}

	@Test
	void testRestEndpointForAddNewNoteIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
		final int count[] = new int[1];
		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		Mockito.when(noteService.addNote(Note)).then(new Answer<Note>() {

			@Override
			public Note answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub

				count[0]++;
				return Note;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/noteservice/add")
				.content(com.yaksha.assessments.notesapp.utils.MasterData.asJsonString(Note))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	/************************ Delete Note ****************/

	@Test
	void testRestEndpointForDeletingNoteIsExposedAndWorking() throws Exception {
		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		Integer id = Note.getId();
		Mockito.when(noteService.deleteNote(id)).thenReturn(Note);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/noteservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(asJsonString(Note)) ? true : false,
				businessTestFile);

	}

	@Test
	void testRestEndpointForDeletingNoteIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
		final int count[] = new int[1];
		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		Integer id = Note.getId();
		Mockito.when(noteService.deleteNote(id)).then(new Answer<Note>() {

			@Override
			public Note answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub

				count[0]++;
				return MasterData.getNote();
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/noteservice/delete/" + id)
				.content(com.yaksha.assessments.notesapp.utils.MasterData.asJsonString(Note))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	/************* Get Single Note ******************/

	@Test
	void testRestEndpointForFindingNoteByIdIsExposedAndWorking() throws Exception {
		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		Integer id = Note.getId();
		Mockito.when(noteService.findById(id)).thenReturn(Note);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/get/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(Note)) ? true : false),
				businessTestFile);

	}

	@Test
	void testRestEndpointForFindingNoteByIdIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
		final int count[] = new int[1];
		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		Integer id = Note.getId();
		Mockito.when(noteService.findById(id)).then(new Answer<Note>() {

			@Override
			public Note answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub

				count[0]++;
				return MasterData.getNote();
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/get/" + id)
				.content(com.yaksha.assessments.notesapp.utils.MasterData.asJsonString(Note))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	/************* Update Note *************************/

	@Test
	public void testRestEndpointForUpdatingIsExposedAndWorking() throws Exception {
		Note note = MasterData.getNote();
		Integer id = 10001;
		String status = "pending";
		note.setId(id);
		note.setStatus(status);
		Mockito.when(noteService.updateNote(note)).thenReturn(note);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/noteservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(note)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	void testRestEndpointForUpdatingIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
		final int count[] = new int[1];
		Integer id = 10001;
		String status = "pending";
		Note note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
		note.setId(id);
		note.setStatus(status);
		Mockito.when(noteService.updateNote(note)).then(new Answer<Note>() {

			@Override
			public Note answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub

				count[0]++;
				return note;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/noteservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testAbleToUseCorrectAnnotationsForCreatingRestEndPoints() throws Exception {
		Note note = MasterData.getNote();
		Integer id = 10001;
		String status = "pending";
		note.setId(id);
		note.setStatus(status);
		Mockito.when(noteService.updateNote(note)).thenReturn(note);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/noteservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(note)) ? "true" : "false"),
				businessTestFile);
	}

	/************ Find By Author *********************/

//	@Test
//	void testRestEndpointForFindingNotesByAuthorIsExposedAndWorking() throws Exception {
//		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		Note note1 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note1.setAuthor("praveen");
//		Note note2 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note2.setAuthor("praveen");
//		List<Note> list = new ArrayList<Note>();
//		list.add(note1);list.add(note2);
//		
//		Mockito.when(noteService.findAllByAuthor("praveen")).thenReturn(list);
//		
//		MvcResult result = mockMvc.perform(get("/noteservice/findByAuthor/praveen").contentType(MediaType.APPLICATION_JSON)).andReturn();
//  		yakshaAssert(currentTest(), 
//  				result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false,
//  				businessTestFile);
//		
//	}
//	@Test
//	void testRestEndpointForFindingNotesByAuthorIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
//		final int count[] = new int[1];
//		Note note1 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		Note note2 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note1.setAuthor("praveen");
//		note2.setAuthor("praveen");
//		List<Note> list = new ArrayList();
//		list.add(note1);
//		list.add(note2);
//		Mockito.when(noteService.findAllByAuthor("praveen")).then(new Answer<List<Note>>() {
//
//			@Override
//			public List<Note> answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				
//				count[0]++;
//				return list;
//			}
//		});
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/findByAuthor/praveen")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		
//	
//		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
//				
//	}

//	@Test
//	void testAbleToAddCustomQueryMethodsToRepository() throws Exception {
//		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		Note note1 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note1.setAuthor("praveen");
//		Note note2 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note2.setAuthor("praveen");
//		List<Note> list = new ArrayList<Note>();
//		list.add(note1);list.add(note2);
//		
//		Mockito.when(noteService.findAllByAuthor("praveen")).thenReturn(list);
//		
//		MvcResult result = mockMvc.perform(get("/noteservice/findByAuthor/praveen").contentType(MediaType.APPLICATION_JSON)).andReturn();
//  		yakshaAssert(currentTest(), 
//  				result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false,
//  				businessTestFile);
//		
//	}

	/*************** Find By Status *****************/

//	@Test
//	void testRestEndpointForFindingNotesByStatusIsExposedAndWorking() throws Exception {
//		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		Note note1 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note1.setStatus("pending");
//		Note note2 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note2.setStatus("pending");
//		List<Note> list = new ArrayList<Note>();
//		list.add(note1);list.add(note2);
//		
//		Mockito.when(noteService.findAllByStatus("pending")).thenReturn(list);
//		
//		MvcResult result = mockMvc.perform(get("/noteservice/findbyStatus/pending").contentType(MediaType.APPLICATION_JSON)).andReturn();
//  		yakshaAssert(currentTest(), 
//  				result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false,businessTestFile);
//		
//	}
//	
//	@Test
//	void testAbleToFetchDataEffectivelyFromDatabaseUsingTraditionalSqlAndHql() throws Exception {
//		Note Note = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		Note note1 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note1.setStatus("pending");
//		Note note2 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note2.setStatus("pending");
//		List<Note> list = new ArrayList<Note>();
//		list.add(note1);list.add(note2);
//		
//		Mockito.when(noteService.findAllByStatus("pending")).thenReturn(list);
//		
//		MvcResult result = mockMvc.perform(get("/noteservice/findbyStatus/pending").contentType(MediaType.APPLICATION_JSON)).andReturn();
//  		yakshaAssert(currentTest(), 
//  				result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false,businessTestFile);
//		
//	}
//	
//	@Test
//	void testRestEndpointForFindingNotesByStatusIsBeingImplementedUsingMultilayerdArchitecture() throws Exception {
//		final int count[] = new int[1];
//		Note note1 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		Note note2 = com.yaksha.assessments.notesapp.utils.MasterData.getNote();
//		note1.setStatus("pending");
//		note2.setStatus("pending");
//		List<Note> list = new ArrayList<Note>();
//		list.add(note1);
//		list.add(note2);
//		Mockito.when(noteService.findAllByStatus("pending")).then(new Answer<List<Note>>() {
//
//			@Override
//			public List<Note> answer(InvocationOnMock invocation) throws Throwable {
//				// TODO Auto-generated method stub
//				
//				count[0]++;
//				return list;
//			}
//		});
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/findbyStatus/pending")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		
//	
//		yakshaAssert(currentTest(),count[0] == 1? true : false,businessTestFile);
//				
//	}
//	

}
