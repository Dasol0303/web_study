package com.app.dao.room.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;
import com.app.dto.room.RoomSearchCondition;

import lombok.extern.slf4j.Slf4j;

//데이터 소스와 통신하는 역할
//DB 연결 역할 -> DAO, Repository(DAO랑 비슷한 의미!!)
//DB:DAO, 외부 API 연동 Repository (이렇게 혼용해서도 사용!)

@Slf4j
@Repository
public class RoomDAOImpl implements RoomDAO{
//인터페이스를(implements RoomDAO) 구현한 객체(class RoomDAOImpl)
	
	//실질적인 DB 연동 처리 관련 객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Room> findRoomList() {
		
		System.out.println("[DAO] 호출 findRoomList");
		
		//DB에서 room 데이터 조회 -> List
		List<Room> roomList = sqlSessionTemplate.selectList("room_mapper.findRoomList");
		
		return roomList;
	}

	@Override
	public int saveRoom(Room room) {
		
		//room 매개변수 값 -> DB에 저장
		
									// 내가 실행할 쿼리가 위치한 식별자
									// namespace.id
		int result = sqlSessionTemplate.insert("room_mapper.saveRoom", room);
		//insert 적용된 행의 숫자가 return 됨.
		
		return result;
	}

	@Override
	public Room findRoomByRoomId(int roomId) {
		Room room = null;
		
		try {
			room = sqlSessionTemplate.selectOne("room_mapper.findRoomByRoomId", roomId);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.warn(e.getMessage());
		}
		
		
		return room;
	}

	@Override
	public int removeRoom(int roomId) {
		
		int result = sqlSessionTemplate.delete("room_mapper.removeRoom", roomId);
		//delete 적용된 행의 수 
		
		return result;
	}

	@Override
	public int modifyRoom(Room room) {
		
		int result = sqlSessionTemplate.update("room_mapper.modifyRoom", room);
		
		return result;
	}

	@Override
	public List<Room> findRoomListBySearchCondition(RoomSearchCondition roomSearchCondition) {
		
		List<Room> roomList = sqlSessionTemplate.selectList("room_mapper.findRoomListBySearchCondition", roomSearchCondition);
		
		return roomList;
	}

	@Override
	public Room findRoomByRoomBuildingName(String buildingName) {
		
		Room room = sqlSessionTemplate.selectOne("room_mapper.findRoomByRoomBuildingName", buildingName);
		
		return room;
	}
	
	
}
