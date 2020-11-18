package com.example.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findById(long id);

	public User findByEmail(String emailAddress);

	public List<User> findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

	public List<User> findByDate(Date date);

	public List<User> findByAddressContains(String partOfAddress);

}
