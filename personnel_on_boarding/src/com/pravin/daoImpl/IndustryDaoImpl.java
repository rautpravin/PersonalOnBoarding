package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pravin.dao.IndustryDao;
import com.pravin.model.Industry;
import com.pravin.util.HibernateUtil;

public class IndustryDaoImpl implements IndustryDao {

	private static IndustryDao industryDao;
	
	private IndustryDaoImpl() {

	}
	
	public static IndustryDao getInstance(){
		if(industryDao==null)
			industryDao = new IndustryDaoImpl();
		return industryDao;
	}

	
	@Override
	public boolean add(Industry industry) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(industry);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null)  tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean update(Industry industry) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(industry);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null)  tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean delete(Industry industry) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(industry);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null)  tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Industry> getAll() {
		List<Industry> industries = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			industries = session.createQuery("from Industry", Industry.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return industries;
	}

	@Override
	public Industry getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			return session.get(Industry.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	
}
