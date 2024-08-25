package com.MySkillHub.rest_mysqlapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MySkillHub.rest_mysqlapp.binding.Course;
import com.MySkillHub.rest_mysqlapp.repo.CourseService;

@RestController
public class CourseRestController {
	@Autowired
	private CourseService coursesrevice;

	@PostMapping("/course")
	public ResponseEntity<String> createCource(@RequestBody Course cousre) {
		String status = coursesrevice.upsert(cousre);
		System.out.println("Post Method is called");
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid) {
		Course course = coursesrevice.getById(cid);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> allcourses = coursesrevice.getAllCourses();
		return new ResponseEntity<List<Course>>(allcourses, HttpStatus.OK);
	}

	@PutMapping("/course")
	public ResponseEntity<String> updatecourse(@RequestBody Course course) {
		String status = coursesrevice.upsert(course);
		System.out.println("Put Method is called");
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	@PatchMapping("/course")
	public ResponseEntity<String> updatecourses(@RequestBody Course course) {
		String status = coursesrevice.upsert(course);
		System.out.println("Put Method is called");
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer cid) {
		String status = coursesrevice.deleteById(cid);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
