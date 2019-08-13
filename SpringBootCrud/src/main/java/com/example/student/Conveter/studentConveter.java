package com.example.student.Conveter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.student.Service.StudentService;
import com.example.student.model.Student;

public class studentConveter implements Converter<Student, Long> {
	@Autowired
	StudentService studentService;
	
	@Override
	public Long convert(Student student) {
	
        Object students= studentService.findById(student.getId());
       
        return Long.parseLong((String)students);
	}

}
