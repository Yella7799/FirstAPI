package com.MySkillHub.rest_mysqlapp.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MySkillHub.rest_mysqlapp.binding.Course;

public interface Courserepo extends JpaRepository<Course, Serializable> {

}
