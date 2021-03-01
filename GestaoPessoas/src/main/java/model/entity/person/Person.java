package model.entity.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.entity.room.Room;

@Entity
@Table(name = "person")
public class Person {
	
//variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private int id;
	
	@Column(name = "f_name_person", length = 20, nullable = false)
	private String firstName;
	
	@Column(name = "l_name_person", length = 20, nullable = false)
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_room")
	private Room room;
	
//constructor
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, Room room) {
		setFName(firstName);
		setLName(lastName);
		setRoom(room);
	}
	
	public Person(int id, String firstName, String lastName, Room room) {
		setId(id);
		setFName(firstName);
		setLName(lastName);
		setRoom(room);
	}
	
//get
	public int getId() {
		return id;
	}
	
	public String getFName() {
		return firstName;
	}
	
	public String getLName() {
		return lastName;
	}
	
	public Room getRoom() {
		return room;
	}
	
//set
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}

}