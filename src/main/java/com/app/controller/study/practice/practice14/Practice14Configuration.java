package com.app.controller.study.practice.practice14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Practice14Configuration {

	//Bean 등록 설정
	
	//CupBean cupBean = new CupBean();
	@Bean
	public CupBean cupBean(CoffeeBean coffeeBean) {
		//Bean 의존성 주입
			
		/*
		//DTO 사용 개념
		CoffeeBean coffeeBean = new CoffeeBean();
		coffeeBean.setName("그린티라떼");
		
		return new CupBean(coffeeBean);
		*/
		
		return new CupBean(coffeeBean);
	}
	
	@Bean
	public CoffeeBean coffeeBean() {
		
		CoffeeBean coffeeBean = new CoffeeBean();
		coffeeBean.setName("그린티라떼");
		
		return coffeeBean;
	}


	//PlateBean plateBean = new PlateBean();
	@Bean
	public PlateBean plateBean(DessertBean desserBean) {
		PlateBean pleatBean = new PlateBean();
		pleatBean.setDessertBean(desserBean);
		
		return pleatBean;
	}
	
	@Bean 
	public DessertBean desserBean() {
		DessertBean desserBean = new DessertBean();
		desserBean.setName("약과");
		
		return desserBean;
	}
	
	
}
