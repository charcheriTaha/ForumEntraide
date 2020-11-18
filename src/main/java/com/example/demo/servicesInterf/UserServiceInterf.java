package com.example.demo.servicesInterf;

import java.sql.Date;
import java.util.List;

import com.example.demo.entities.Publication;
import com.example.demo.entities.User;

public interface UserServiceInterf {

	public User findUser(long userId);

	public Long saveUser(User user);

	public Long updateUser(User user);

	public void deleteUser(User user);

	public List<User> usersList();

	public User findUserByEmail(String email);
	
	public List<User> getUsersByDate(Date date);

	public List<User> getUsersByAdress(String adress);

	public User getUserById(long id);

	public void deleteUserById(long id);

	public List<User> getUsersByFirstName(String firstName);

	public List<User> getUsersByAddressContaining(String partOfAddress);

}
