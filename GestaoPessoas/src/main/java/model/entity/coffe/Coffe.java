package model.entity.coffe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entity.room.Room;

@Entity
@Table(name = "coffe")
public class Coffe {
	
//variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coffe")
	private int id;
	
	@Column(name = "name_coffe", length = 15, nullable = false, unique = true)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_room")
	private Room room;
	
//constructor
	public Coffe() {
		
	}
	
	public Coffe(String name) {
		setName(name);
	}
	
	public Coffe(int id, String name) {
		setId(id);
		setName(name);
	}
	
//get
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Room getRoom() {
		return room;
	}
	
//set
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}

}