package com.pravin.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pravin.dao.IndustrySectorDao;
import com.pravin.model.IndustrySector;
import com.pravin.util.HibernateUtil;

public class IndustrySectorDaoImpl implements IndustrySectorDao {

	private static IndustrySectorDao industrySectorDao;
	
	private IndustrySectorDaoImpl() {
		
	}
	
	public static IndustrySectorDao getInstance(){
		if(industrySectorDao==null)
			industrySectorDao = new IndustrySectorDaoImpl();
		
		return industrySectorDao;
	}

	@Override
	public boolean add(IndustrySector industrySector) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(industrySector);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			System.out.println("1) Exception industry-sector-dao : "+e.getMessage());
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean update(IndustrySector industrySector) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(industrySector);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			System.out.println("2) Exception industry-sector-dao : "+e.getMessage());
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean delete(IndustrySector industrySector) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(industrySector);
			tx.commit();
			return true;
		}catch(Exception e){
			if(tx!=null) tx.rollback();
			System.out.println("3) Exception industry-sector-dao : "+e.getMessage());
			return false;
		}finally{
			session.close();
		}
	}

	@Override
	public List<IndustrySector> getAll() {
		List<IndustrySector> industrySectors = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			industrySectors = session.createQuery("from IndustrySector", IndustrySector.class).getResultList();
		}catch(Exception e){
			System.out.println("4) Exception industry-sector-dao : "+e.getMessage());
		}finally{
			session.close();
		}
		return industrySectors;
	}

	@Override
	public IndustrySector getById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			return session.get(IndustrySector.class, id);
		}catch(Exception e){
			System.out.println("4) Exception industry-sector-dao : "+e.getMessage());
			return null;
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<IndustrySector> getByIndustry(int id) {
		List<IndustrySector> industrySectors = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			industrySectors = session.createQuery("from IndustrySector s where s.industry.industryId = :industryId", IndustrySector.class).setParameter("industryId", id).getResultList();
		}catch(Exception e){
			System.out.println("5) Exception industry-sector-dao : "+e.getMessage());
		}finally{
			session.close();
		}
		return industrySectors;
	}
	
	
	
}
