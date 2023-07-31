package com.yaksha.assessments.notesapp.functional;

import static com.yaksha.assessments.notesapp.utils.TestUtils.businessTestFile;
import static com.yaksha.assessments.notesapp.utils.TestUtils.currentTest;
import static com.yaksha.assessments.notesapp.utils.TestUtils.testReport;
import static com.yaksha.assessments.notesapp.utils.TestUtils.yakshaAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaksha.assessments.notesapp.entity.Note;
import com.yaksha.assessments.notesapp.repository.NoteRepository;
import com.yaksha.assessments.notesapp.service.NoteServiceImpl;
import com.yaksha.assessments.notesapp.utils.MasterData;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class SkillTest {

	@Mock
	private NoteRepository repository;

	@Autowired
	@InjectMocks
	private NoteServiceImpl noteService;

	/*
	 * @BeforeEach public void setUp() { this.noteService = new NoteServiceImpl(); }
	 */

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testStreamsAreUsedToIterateCollections() throws Exception {
		final int count[] = new int[1];

		List<Note> notes = new ArrayList<Note>();
		Note note1 = MasterData.getNote();
		notes.add(note1);
		Note note2 = MasterData.getNote();
		note2.setId(2);
		notes.add(note1);

		/*
		 * List<NotesDto> noteDtos = new ArrayList<NotesDto>(); NotesDto noteDto1 =
		 * MasterData.getNotesDto(); noteDtos.add(noteDto1); NotesDto noteDto2 =
		 * MasterData.getNotesDto(); noteDto2.setId(2); noteDtos.add(noteDto1);
		 */
		List<Note> list = Mockito.mock(List.class);
		Mockito.when(this.repository.findAll()).thenReturn(list);

		Mockito.when(list.stream()).then(new Answer<Stream<Note>>() {

			@Override
			public Stream<Note> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return notes.stream();
			}

		});
		try {
			List<Note> noteDtos = this.noteService.findAll();
		} catch (Exception ex) {
			System.out.println(ex);
			yakshaAssert(currentTest(), false, businessTestFile);
			return;

		}
		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
	}

	@Test
	public void testAbleToUseLambdas() throws Exception {
		final int count[] = new int[1];

		List<Note> notes = new ArrayList<Note>();
		Note note1 = MasterData.getNote();
		notes.add(note1);
		Note note2 = MasterData.getNote();
		note2.setId(2);
		notes.add(note1);

		/*
		 * List<NotesDto> noteDtos = new ArrayList<NotesDto>(); NotesDto noteDto1 =
		 * MasterData.getNotesDto(); noteDtos.add(noteDto1); NotesDto noteDto2 =
		 * MasterData.getNotesDto(); noteDto2.setId(2); noteDtos.add(noteDto1);
		 */
		List<Note> list = Mockito.mock(List.class);
		Mockito.when(this.repository.findAll()).thenReturn(list);

		Mockito.when(list.stream()).then(new Answer<Stream<Note>>() {

			@Override
			public Stream<Note> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("Called");
				count[0]++;
				return notes.stream();
			}

		});
		try {
			List<Note> noteDtos = this.noteService.findAll();
		} catch (Exception ex) {
			System.out.println(ex);
			yakshaAssert(currentTest(), false, businessTestFile);
			return;

		}
		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
	}
}
