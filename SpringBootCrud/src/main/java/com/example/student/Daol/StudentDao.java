package com.example.student.Daol;

import java.util.List;

import com.example.student.model.Student;

public interface StudentDao {

	public void save(Student student);

	public List<Student> getList();

	public Student findById(Long id);

	public void update(Student student);

	public void delete(Long id);

}
