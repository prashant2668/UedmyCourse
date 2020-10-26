package com.prashant.test.webservices.restwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<>();
	private static int userCount=3;

	static {

		users.add(new User("Prashant", 1, new Date()));
		users.add(new User("Mayur", 2, new Date()));
		users.add(new User("Abhi", 3, new Date()));
	}


	public List<User> findAll(){

		return users;
	}


	public User save(User user) {

		if (user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}


	public User findOne(int id) {
		for (User user : users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public User deleteOne(int id) {

		Iterator iterator=users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
}


