package model.dao.room;

import java.util.List;

import model.entity.room.Room;

public interface RoomDAO {
	
	void insertRoom(Room room);
	
	void updateRoom(Room room);
	
	void deleteRoom(Room room);
	
	List<Room> listRoom();

}
