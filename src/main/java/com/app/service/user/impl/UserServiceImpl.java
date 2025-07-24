package com.app.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.dao.user.UserDAO;
import com.app.dto.room.Room;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service	//Bean 등록이 됨!! Service 어노테이션을 붙였기 때문에!!
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;


	@Override
	public int saveUser(User user) {

		int result = userDAO.saveUser(user);

		return result;
	}


	@Override
	public int saveAdminUser(User user) {
		//관리자 계정 추가 할때 필요한 체크 로직....

		//user.setUserType("ADM");
		user.setUserType( CommonCode.USER_USERTYPE_ADMIN );
		int result = userDAO.saveUser(user);

		return result;
	}


	@Override
	public int saveCustomerUser(User user) {
		//사용자 계정 추가 할때 필요한 체크 로직....

		//user.setUserType("CUS");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		int result = userDAO.saveUser(user);

		return result;
	}


	@Override
	public List<User> findUserList() {

		List<User> userList = userDAO.findUserList();

		return userList;
	}


	@Override
	public User findUserById(String id) {

		User user = userDAO.findUserById(id);

		return user;
	}


	//로그인 정상적으로 시켜줄건지?
	@Override
	public User checkUserLogin(User user) {
		//매개변수로 들어온 User 객체에 id, pw, userType 로그인을 처리할 수 있는 정상적인 값을 가지고 있는지 여부 체크 
		//메소드 주요 로직 -> 로그인 처리 성공? 실패?

		//id pw 일치하는가?

		/*
		//case 1) DB에서 정보를 조회 한 후 -> Service Layer 상태에서 비교하는 로직을 수행!

		//사용자 정보를 조회해서, id pw 맞나 확인
		User loginUser = userDAO.findUserById(user.getId());

		//if(loginUser.getPw().equals(user.getPw())) { 
		//이렇게 바로 비교하는 건 좀 위험함! => NULL의 경우 loginUser.getPw()에서 NULL오류 발생!!
		//그래서 밑에 로직처럼 null을 먼저 거르는 조건을 무조건으로 걸어줌!!
		if( loginUser != null && loginUser.getPw().equals(user.getPw()) 
							  && loginUser.getUserType().equals(user.getUserType())) {
			return loginUser;
		}
		// checkUserLogin 메소드 호출 -> return null? id,pw 틀렸다
		//	  return user 객체 ? -> 맞다! 

		return null;
		*/

		/*
 			return 의미가 담긴 코드 (SUC, FAL, LCK)... 
 			int 숫자 return -> 1:성공 2:id는 맞는데 비번이 틀렸다 3:아이디 없다
 							 4:신고로 잠겼다 5:휴면계정 6:....
		  	=> 를 정해줘서 사용 가능
		 */

		
		//case 2) DB에서 쿼리를 통해, 정상여부 체크 로직 수행
		// userDAO.checkUserLogin -> sql query 상에서 id, pw, userType 동일한 경우를 체크

		User loginUser = userDAO.checkUserLogin(user);
		
		return loginUser;

	}


	@Override
	public int modifyUserPw(User user) {
		
		int result = userDAO.modifyUserPw(user);
		
		return result;
	}


	@Override
	public int modifyUser(User user) {
		
		int result = userDAO.modifyUser(user);
		
		return result;
	}






}
