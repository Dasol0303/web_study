package com.app.dto.study.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	//얘가 있어야 밑에 오류 안남
@AllArgsConstructor //전체 파라미터를 받는 생성자
public class ApiMenu {
	String name;
	int price;
}
