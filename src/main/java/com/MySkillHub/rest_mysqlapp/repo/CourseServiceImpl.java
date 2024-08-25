package com.MySkillHub.rest_mysqlapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MySkillHub.rest_mysqlapp.binding.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private Courserepo courserepo;

	@Override
	public String upsert(Course course) {
		courserepo.save(course); // insert or update based on primary key
		System.out.println("Save method is called");
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courserepo.findById(cid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return courserepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if (courserepo.existsById(cid)) {
			courserepo.deleteById(cid);
			return "Delete Success";
		} else {
			return "No record Found";
		}
	}

}
