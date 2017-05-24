package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pravin.dao.CountryDao;
import com.pravin.model.Country;
import com.pravin.util.HibernateUtil;

public class CountryDaoImpl implements CountryDao{

	private static CountryDao countryDao;
	
	private CountryDaoImpl(){
		
	}
	
	public static CountryDao getInstance(){
		if(countryDao==null) countryDao = new CountryDaoImpl();
		return countryDao;
	}
	
	@Override
	public boolean add(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(country);
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
	public boolean update(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(country);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			
		}
				
		
	}

	@Override
	public boolean delete(Country country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(country);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			
		}
	}

	@Override
	public Country getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			return session.get(Country.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Country> getAll() {
		List<Country> countries = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			countries = session.createQuery("from Country", Country.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception : "+e.getMessage());
		}finally{
			session.close();
		}
		
		return countries;
	}

}
