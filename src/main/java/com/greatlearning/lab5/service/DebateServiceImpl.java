package com.greatlearning.lab5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.greatlearning.lab5.entity.Student;



@Repository
public class DebateServiceImpl implements DebateService{

	//create sessionFactory and session
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@Autowired
	DebateServiceImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		try {
			session=this.sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session=this.sessionFactory.openSession();
		}
	}
	
	
	@Transactional
	public List<Student> getAllStudents() {
		Transaction tx=session.beginTransaction();
		List<Student> students=session.createQuery("from Student").list();
		tx.commit();
		return students;
	}

	@Transactional
	public void registerStudent(Student newStudent) {
		Transaction currentTx=session.beginTransaction();
		session.saveOrUpdate(newStudent);
		currentTx.commit();
	}

	@Transactional
	public void deleteStudent(int stuId) {
		Transaction currentTx=session.beginTransaction();
		session.createQuery("delete Student where id="+stuId).executeUpdate();
		currentTx.commit();
	}

	@Transactional
	public void updateStudent(Student theStudent) {
		Transaction currentTx=session.beginTransaction();
		session.update(theStudent);
		currentTx.commit();
	}

	@Transactional
	public Student findById(int theId) {
		Student s=new Student();
		Transaction tx=session.beginTransaction();
		s=session.get(Student.class, theId);
		tx.commit();
		return s;
	}

}
