package com.MySkillHub.rest_mysqlapp.repo;

import java.util.List;

import com.MySkillHub.rest_mysqlapp.binding.Course;

public interface CourseService {
	public String upsert(Course course);

	public Course getById(Integer cid);

	public List<Course> getAllCourses();

	public String deleteById(Integer cid);

}
