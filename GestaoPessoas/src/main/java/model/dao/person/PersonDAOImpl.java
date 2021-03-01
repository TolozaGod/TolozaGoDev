package model.dao.person;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.person.Person;
import model.factory.connection.ConnectionFactory;

public class PersonDAOImpl implements PersonDAO {
	
	private ConnectionFactory factory;
	
	public PersonDAOImpl() {
		factory = new ConnectionFactory();
	}
	
	public void insertPerson(Person person) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.save(person);
			
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
	
	public void updatePerson(Person person) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.update(person);
			
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
	
	public void deletePerson(Person person) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.remove(person);
			
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
	
	public List<Person> listPerson(){
		
		Session session = null;
		List<Person> person = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<Person> cq = cb.createQuery(Person.class);
			Root<Person> r = cq.from(Person.class);
			
			cq.select(r);
			
			person = session.createQuery(cq).getResultList();
			
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
		
		return person;
		
	}

}