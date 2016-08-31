package com.jj.demo.springmvc.dao;

import com.jj.demo.springmvc.db.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	public User selectByUserName(String username) {
		if (!"admin".equals(username)) {
			return null;
		}
		User user = new User();
		user.setUserName("admin");
		user.setPassword("123");
		return user;
	}

}
