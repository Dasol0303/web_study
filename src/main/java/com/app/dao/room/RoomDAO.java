package com.app.dao.room;

import java.util.List;

import com.app.dto.room.Room;

public interface RoomDAO {

	List<Room> findRoomList();
	
	int saveRoom(Room room);
	
	//하나의 리턴타입이 나올거라서 Room!
	Room findRoomByRoomId(int roomId);
}
