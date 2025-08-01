package com.app.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter //필드에 대한 setter를 자동으로 인식해주는 기능!
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor

@Data
public class Room { 

	int roomId;		//PK 기본키 식별자
	String buildingName;	//동 이름	101	A B 301
	int roomNumber; //호실번호 1101  2307
	int floor; //층수  7층 8층
	int maxGuestCount; //최대 숙박인원
	String viewType; //뷰 구분 코드
					// 오션뷰 시티뷰 마운틴뷰
					// OCN	CTY	 MOT
					// 1	2	 3	=> 이건 나중에 뭐였지..? 할 수 있어서 X!!
	
	
	
}
