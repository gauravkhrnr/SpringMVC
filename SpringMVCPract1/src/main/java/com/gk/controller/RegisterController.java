package com.gk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gk.dao.UserDaoImpl;
import com.gk.model.User;

@Controller
public class RegisterController {

	@Autowired
	UserDaoImpl userDaoImpl;
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public ModelAndView addUser() {
		
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("user",new User());
		return modelAndView;
		
	}
	
	@RequestMapping(value="/registerProcess",method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute("user") User user) {
	
		System.out.println(user.getPassword());
		int result = userDaoImpl.register(user);
		if(result == 1){
			
			return new ModelAndView("welcome","name",user.getFirstname());
		}else
		{
			return new ModelAndView("error");
		}
	}
}
