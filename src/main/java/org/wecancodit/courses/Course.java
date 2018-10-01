package org.wecancodit.courses;

public class Course {

	private String courseDescription;
	private String courseName;
	private long id;

	public Course(long id, String courseName, String courseDescription) {
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public Long getId() {
		return id;
	}

}
