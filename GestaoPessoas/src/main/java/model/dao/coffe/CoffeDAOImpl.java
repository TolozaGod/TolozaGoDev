package model.dao.coffe;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.coffe.Coffe;
import model.factory.connection.ConnectionFactory;

public class CoffeDAOImpl implements CoffeDAO {
	
	private ConnectionFactory factory;
	
	public CoffeDAOImpl() {
		factory = new ConnectionFactory();
	}
	
	public void insertCoffe(Coffe coffe) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.save(coffe);
			
			session.getTransaction().commit();
			
		}
		catch(Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
		finally {
			
			if(session != null) {
				session.close();
			}
		}
	}
	
	public void updateCoffe(Coffe coffe) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.update(coffe);
			
			session.getTransaction().commit();
			
		}
		catch(Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
		finally {
			
			if(session != null) {
				session.close();
			}
		}
	}
	
	public void deleteCoffe(Coffe coffe) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.remove(coffe);
			
			session.getTransaction().commit();
			
		}
		catch(Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			
		}
		finally {
			
			if(session != null) {
				session.close();
			}
		}
	}
	
	public List<Coffe> listCoffe(){
		
		Session session = null;
		List<Coffe> coffe = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<Coffe> cq = cb.createQuery(Coffe.class);
			Root<Coffe> r = cq.from(Coffe.class);
			
			cq.select(r);
			
			coffe  = session.createQuery(cq).getResultList();
			
			session.getTransaction().commit();
			
		}
		catch(Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
		finally {
			
			if(session != null) {
				session.close();
			}
		}
		
		return coffe;
		
	}

}