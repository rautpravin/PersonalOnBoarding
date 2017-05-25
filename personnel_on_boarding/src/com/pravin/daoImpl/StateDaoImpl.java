package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pravin.dao.StateDao;
import com.pravin.model.State;
import com.pravin.util.HibernateUtil;

public class StateDaoImpl implements StateDao{

	private static StateDao stateDao;

	private StateDaoImpl(){
		
	}
	
	public static StateDao getInstance(){
		if(stateDao==null)
			stateDao = new StateDaoImpl();
		
		return stateDao;
	}
	
	@Override
	public boolean add(State state) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			state.getCountry();
			session.save(state);
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
	public boolean update(State state) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(state);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			
			return false;
		}finally{
			session.close();
		}
		
	}

	@Override
	public boolean delete(State state) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(state);
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
	public List<State> getAll() {
		List<State> states = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
		session.beginTransaction();
		states = session.createQuery("from State", State.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return states;
	}

	@Override
	public State getById(int id) {
		State state = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			state = session.get(State.class, id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return state;
	}

	@Override
	public List<State> getByCountryId(int id) {
		List<State> states = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Query<State> q = session.createQuery("from State s where s.country.countryId = :countryId", State.class).setParameter("countryId", id);
			states = q.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return states;
	}
	
}
