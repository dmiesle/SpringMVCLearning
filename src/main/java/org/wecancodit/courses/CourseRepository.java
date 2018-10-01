package org.wecancodit.courses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class CourseRepository {

	private Map<Long, Course> courseList = new HashMap<>();


	public CourseRepository( ) {
		Course java = new Course (1L, "Java", "Java Description");
		Course javaScript = new Course (2L, "Java Script", "Java Script Description");
		Course spring = new Course (3L, "Spring", "Spring Description");
		
		courseList.put(java.getId(), java);
		courseList.put(javaScript.getId(), javaScript);
		courseList.put(spring.getId(), spring);
	}
	//Constructor for testing purposes
	public CourseRepository(Course...courses) {
		for (Course course : courses) {
			courseList.put(course.getId(), course);
		}
	}

	public Course getCourseId(long id) {
		return courseList.get(id);
	}

	public Collection<Course> findAll() {
		return courseList.values();
	}

	public long findCourse(long course) {
		return course;
	}

}
