package com.example.student.Service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.Daol.StudentDao;
import com.example.student.Service.StudentService;
import com.example.student.model.Student;

@Service
@Transactional
public class StudentServiceImple implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public void save(Student student) {
	studentDao.save(student);
	}


	@Override
	public List<Student> getList() {
		return studentDao.getList();
	}


	@Override
	public Student findById(Long id) {
		
		return studentDao.findById(id);
	}


	@Override
	public void update(Student student,Long id) {
		Student students = studentDao.findById(id);
		students.setId(id);
		students.setName(student.getName());
		students.setEmail(student.getEmail());
		students.setContact(student.getContact());
		students.setBirthDate(student.getBirthDate());
		studentDao.update(students);
	}


	@Override
	public void delete(Long id) {
		studentDao.delete(id);
		
	}

}
