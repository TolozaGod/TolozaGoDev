package model.dao.person;

import java.util.List;

import model.entity.person.Person;

public interface PersonDAO {
	
	void insertPerson(Person person);
	
	void updatePerson(Person person);
	
	void deletePerson(Person person);
	
	List<Person> listPerson();

}