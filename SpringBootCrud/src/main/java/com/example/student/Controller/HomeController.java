package com.example.student.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.student.Service.StudentService;
import com.example.student.model.Student;
import com.example.student.validator.StudentValidator;

import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
    private StudentValidator studentValidator;
     
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(studentValidator);
    }
     
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String findByid(Model model) {
		List<Student> studentList = studentService.getList();
		model.addAttribute("studentList", studentList);
		return "Home";
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String getHome(ModelMap model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "registration";
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String getHomes(Model model, @Valid Student student, BindingResult result) {
		String returnVal = "success";
		if(result.hasErrors()) {
            returnVal = "student";
        }
		else {
		studentService.save(student);
		model.addAttribute("student", student);
        } 
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit( ModelMap model,@PathVariable Long id) {
		Student student=studentService.findById(id);
		model.addAttribute("Student", student);
		return "registration";
	}
	
	@RequestMapping( value="/edit/{id}", method=RequestMethod.POST)
	public String update(ModelMap model,@PathVariable Long id, Student student, BindingResult result) {
		studentService.update(student,id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(ModelMap model,@PathVariable Long id) {
		Student student= new Student();
		studentService.delete(id);
		List<Student> studentList = studentService.getList();
		model.addAttribute("studentList", studentList);
		return "Home";
	}
}
