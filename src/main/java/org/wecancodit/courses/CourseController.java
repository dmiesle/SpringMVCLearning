package org.wecancodit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
	
	@Resource
	CourseRepository courseRepo;
	
	@RequestMapping("/show-courses")
	public String findAllCourses(Model model) {
		model.addAttribute("courses", courseRepo.findAll());
		return "courses";
	}
	
	@RequestMapping("/show-course")
	public String findCourses(@RequestParam(value="id") Long id, Model model) {
		model.addAttribute("courses", courseRepo.findCourse(id));
		return "course";
	}

}
