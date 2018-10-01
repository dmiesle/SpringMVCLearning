package org.wecancodit.courses;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static java.util.Arrays.asList;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerMockMVCTest {

	@Resource
	private MockMvc mvc;
	
	@Mock
	private Course course;
	
	@Mock
	private Course course2;
	
	@MockBean
	private CourseRepository repository;
	
	@Test
	public void shouldBeOkForAllCourses() throws Exception{
		mvc.perform(get("/show-courses")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToAllCoursesVeiw() throws Exception {
		mvc.perform(get("/show-courses")).andExpect(view().name("courses"));
	}
	
	@Test
	public void shouldPutAllCoursesIntoModel() throws Exception{
		Collection<Course>allCourses = asList(course, course2);
		when(repository.findAll()).thenReturn(allCourses);
		mvc.perform(get("/show-courses")).andExpect(model().attribute("courses", is(allCourses)));
	}
	
	@Test
	public void shouldBeOkForSingleCourse() throws Exception{
		mvc.perform(get("/show-course?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToCourseVeiw() throws Exception {
		mvc.perform(get("/show-course?id=1")).andExpect(view().name("course"));
	}
	
	@Test
	public void shouldPutASingleCourseIntoModel() throws Exception{
		when(repository.findCourse(1L)).thenReturn(course);
		mvc.perform(get("/show-course?id=1")).andExpect(model().attribute("course", is(course)));
	}
	
	
}
