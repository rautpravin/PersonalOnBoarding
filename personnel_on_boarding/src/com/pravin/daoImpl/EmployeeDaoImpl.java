package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pravin.dao.EmployeeDao;
import com.pravin.model.Employee;
import com.pravin.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean add(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null) 
				tx.rollback();
			return false;
		}finally{
			session.close();
		}
		
	}

	@Override
	public boolean update(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null) tx.rollback();
			return false;
		}finally{
			session.close();
		}
		
	}

	@Override
	public boolean delete(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null) tx.rollback();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public Employee getById(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			return (Employee)session.get(Employee.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			employees = session.createQuery("from Employee", Employee.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return employees;
	}

	@Override
	public long getCount() {
		long count = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
			criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(Employee.class)));
			count = session.createQuery(criteriaQuery).getSingleResult();
			
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null) tx.rollback();
		}finally{
			session.close();
		}
		return count;
	}
	
	
	@Override 
	public List<Employee> getManagers(){
		List<Employee> managers = new ArrayList<>();
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			managers = session.createQuery("from Employee e where e.manager_id = null", Employee.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return managers;
	}
}
