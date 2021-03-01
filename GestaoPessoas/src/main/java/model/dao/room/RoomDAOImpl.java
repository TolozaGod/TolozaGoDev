package model.dao.room;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.room.Room;
import model.factory.connection.ConnectionFactory;

public class RoomDAOImpl implements RoomDAO {
	
	private ConnectionFactory factory;
	
	public RoomDAOImpl() {
		factory = new ConnectionFactory();
	}
	
	public void insertRoom(Room room) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.save(room);
			
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
	
	public void updateRoom(Room room) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.update(room);
			
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
	
	public void deleteRoom(Room room) {
		
		Session session = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			session.remove(room);
			
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
	
	public List<Room> listRoom(){
		
		Session session = null;
		List<Room> room = null;
		
		try {
			
			session = factory.getConnection().openSession();
			session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<Room> cq = cb.createQuery(Room.class);
			Root<Room> r = cq.from(Room.class);
			
			cq.select(r);
			
			room = session.createQuery(cq).getResultList();
			
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
		
		return room;
		
	}

}