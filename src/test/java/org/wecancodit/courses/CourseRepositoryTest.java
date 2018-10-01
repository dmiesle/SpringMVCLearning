package org.wecancodit.courses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryTest {
	CourseRepository underTest;
	
	private long id = 1L;
	private long id2 = 2L;
	private Course course = new Course(id, "course name", "discription");
	private Course course2 = new Course(id2, "course name", "discription");
	
	@Test
	public void shouldFindACourse() {
		underTest = new CourseRepository(course);
		Course result = underTest.getCourseId(id);
		assertThat(result, is(course));
		}
	
	@Test
	public void shoudlFindASecondCourse() {
		underTest = new CourseRepository(course2);
		Course result = underTest.getCourseId(id2);
		assertThat(result, is(course2));
	}
	
	@Test
	public void shouldFindAllCourses() {
		underTest = new CourseRepository(course, course2);
		Collection<Course> result = underTest.findAll();
		assertThat(result, containsInAnyOrder(course, course2));
	}
	
}
