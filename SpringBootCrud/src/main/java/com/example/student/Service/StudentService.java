package com.example.student.Service;

import java.util.List;

import com.example.student.model.Student;

public interface StudentService {

	public void save(Student student);

	public List<Student> getList();

	public Student findById(Long id);

	public void update(Student student, Long id);

	public void delete(Long id);

}
