package model.dao.coffe;

import java.util.List;

import model.entity.coffe.Coffe;

public interface CoffeDAO {
	
	void insertCoffe(Coffe cofffe);
	
	void updateCoffe(Coffe coffe);
	
	void deleteCoffe(Coffe coffe);
	
	List<Coffe> listCoffe();

}