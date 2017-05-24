package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pravin.dao.CityDao;
import com.pravin.model.City;
import com.pravin.util.HibernateUtil;

public class CityDaoImpl implements CityDao {

	private static CityDao cityDao;
	
	private CityDaoImpl(){
		
	}
	
	public static CityDao getInstance(){
		if(cityDao==null)
			cityDao = new CityDaoImpl();
		
		return cityDao;
	}
	
	@Override
	public boolean add(City city) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(city);
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
	public boolean update(City city) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(city);
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
	public boolean delete(City city) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(city);
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
	public List<City> getAll() {
		List<City> cities = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			cities = session.createQuery("from City", City.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return cities;
	}

	@Override
	public City getById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			return session.get(City.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public List<City> getByStateId(long id) {
		List<City> cities = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query<City> q= session.createQuery("from City c where c.state.stateId = :stateId", City.class).setParameter("stateId", id);
			cities = q.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return cities;
	}

}
