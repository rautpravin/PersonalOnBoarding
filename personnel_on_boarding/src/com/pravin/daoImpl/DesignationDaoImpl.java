package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pravin.dao.DesignationDao;
import com.pravin.model.Designation;
import com.pravin.util.HibernateUtil;

import sun.security.krb5.internal.crypto.Des;

public class DesignationDaoImpl implements DesignationDao{
	
	private static DesignationDao designationDao;
	
	private DesignationDaoImpl() {
	
	}
	
	public static DesignationDao getInstance(){
		if(designationDao==null)
			designationDao = new DesignationDaoImpl();
		return designationDao;
	}

	@Override
	public boolean add(Designation designation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.save(designation);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean update(Designation designation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.update(designation);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean delete(Designation designation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.delete(designation);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Designation> getAll() {
		List<Designation> designations = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			designations = session.createQuery("from Designation", Designation.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return designations;
	}

	@Override
	public Designation getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			Designation designation = session.get(Designation.class, id);
			return designation;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	
}
