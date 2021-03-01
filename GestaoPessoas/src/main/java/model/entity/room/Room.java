package model.entity.room;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entity.coffe.Coffe;
import model.entity.person.Person;

@Entity
@Table(name = "room")
public class Room {
	
//variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_room")
	private int id;
	
	@Column(name = "name_room", length = 15, nullable = false, unique = true)
	private String name;
	
	@Column(name = "capacity_room", nullable = false)
	private int capacity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Person> people = new ArrayList<Person>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_coffe")
	private Coffe coffe;
	
//constructor
	public Room() {
		
	}
	
	public Room(String name, int capacity, Coffe coffe) {
		setName(name);
		setCapacity(capacity);
		setCoffe(coffe);
	}
	
	public Room(int id, String name, int capacity, Coffe coffe) {
		setId(id);
		setName(name);
		setCapacity(capacity);
		setCoffe(coffe);
	}
	
//get
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public List<Person> getPeople(){
		return people;
	}
	
	public Coffe getCoffe() {
		return coffe;
	}
	
//set
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void addPeople(Person person) {
		this.people.add(person);
	}
	
	public void removePeople(Person person) {
		this.people.remove(person);
	}
	
	public void setCoffe(Coffe coffe) {
		this.coffe = coffe;
	}

}