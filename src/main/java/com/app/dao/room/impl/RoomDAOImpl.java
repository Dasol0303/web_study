package com.app.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

//데이터 소스와 통신하는 역할
//DB 연결 역할 -> DAO, Repository(DAO랑 비슷한 의미!!)
//DB:DAO, 외부 API 연동 Repository (이렇게 혼용해서도 사용!)

@Repository
public class RoomDAOImpl implements RoomDAO{
//인터페이스를(implements RoomDAO) 구현한 객체(class RoomDAOImpl)
	
	
	@Override
	public List<Room> findRoomList() {
		
		//DB에서 room 데이터 조회 -> List
		
		
		return null;
	}
	
	
	
	
}
