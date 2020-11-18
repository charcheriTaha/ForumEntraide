package com.example.demo.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.servicesInterf.UserServiceInterf;

@Service("userService")
public class UserService implements UserServiceInterf {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public Long saveUser(User user) {
		// TODO Auto-generated method stub
		User u = userRepository.saveAndFlush(user);
		return u.getId();
	}

	@Override
	public Long updateUser(User user) {
		// TODO Auto-generated method stub
		User u = userRepository.saveAndFlush(user);
		return u.getId();
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);

	}

	@Override
	public List<User> usersList() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> getUsersByAdress(String adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findByFirstName(firstName) ;
	}

	@Override
	public List<User> getUsersByAddressContaining(String partOfAddress) {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findByAddressContains(partOfAddress);
	}

	@Override
	public List<User> getUsersByDate(Date date) {
		// TODO Auto-generated method stub
		return  userRepository.findByDate(date);
	}

	

}
