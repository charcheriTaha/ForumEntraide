package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.entities.User;
import com.example.demo.servicesInterf.UserServiceInterf;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceInterf userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user_form");
		return mv;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView userSave(@ModelAttribute("userForm") User user) {
		System.out.println("0: " + user.getId());
		System.out.println("1: " + user.getFirstName());
		System.out.println("2: " + user.getLastName());
		System.out.println("3: " + user.getEmail());
	    //System.out.println("4: " + user.getCin());
		System.out.println("4: " + user.getMobile());
		System.out.println("5: " + user.getAddress());
		System.out.println("6: " + user.getDate());
		userService.saveUser(user);
		return new ModelAndView("redirect:/user/list");

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("user_list");
		List<User> userList = userService.usersList();
		mv.addObject("usersList", userList);
		return mv;
	}

	// path variable firstName
		@RequestMapping(value ="/searching list by name", method = RequestMethod.POST)
		public ModelAndView listByName(@ModelAttribute("fn") String firstName) {
			ModelAndView mv = new ModelAndView("user_list");
			List<User> usersList = userService.getUsersByFirstName(firstName);
			mv.addObject("usersList", usersList);
			return mv;
		}

	@RequestMapping(value ="/searching list by address containing", method = RequestMethod.POST)
	public ModelAndView listByAddressContaining(@ModelAttribute("ad") String partOfAddress) {
		System.out.println("Hi , di you search " + partOfAddress + " ?");
		ModelAndView mv = new ModelAndView("user_list");
		List<User> usersList = userService.getUsersByAddressContaining(partOfAddress);
		mv.addObject("usersList", usersList);
		return mv;

	}
	
	@RequestMapping(value="/updateUser/{id}", method=RequestMethod.GET)
	public ModelAndView editUser(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserById(id);
		mv.addObject("userForm", user);
		mv.setViewName("user_form_update");
		return mv;
	}

	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
	  userService.deleteUserById(id);
	return new ModelAndView("redirect:/user/list");
	}
}
