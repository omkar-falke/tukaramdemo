package com.example.student.Dao.Daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.Daol.StudentDao;
import com.example.student.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Student student) {
		Session session=sessionFactory.getCurrentSession();
		session.save(student);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Student> getList() {
		Session session=sessionFactory.getCurrentSession();
		return session.createCriteria(Student.class).list();
		
	}

	@Override
	public Student findById(Long id) {
		Session session=sessionFactory.getCurrentSession();
		Student student=(Student) session.get(Student.class,id);
		return student;
	}

	@Override
	public void update(Student student) {
		Session session=sessionFactory.getCurrentSession();
		session.update(student);
		
	}

	@Override
	public void delete(Long id) {
		Session session=sessionFactory.getCurrentSession();
		Student student=findById(id);
		session.delete(student);
	}

}
