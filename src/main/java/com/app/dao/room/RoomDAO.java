package com.app.dao.room;

import java.util.List;

import com.app.dto.room.Room;
import com.app.dto.room.RoomSearchCondition;

public interface RoomDAO {

	List<Room> findRoomList();
	
	int saveRoom(Room room);
	
	//하나의 리턴타입이 나올거라서 Room!
	Room findRoomByRoomId(int roomId);
	
	Room findRoomByRoomBuildingName(String buildingName);

	int removeRoom(int roomId);
	
	int modifyRoom(Room room);
	
	public List<Room> findRoomListBySearchCondition(RoomSearchCondition roomSearchCondition);
	
}
