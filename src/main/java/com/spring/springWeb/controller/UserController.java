package com.spring.springWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springWeb.model.User;
import com.spring.springWeb.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserService userService;
	 
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView("/user/login");
		modelAndView.addObject("userForm", new User());
		return modelAndView;
	}
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		User userObj = userService.authenticate(user);
		if(userObj != null) {
			modelAndView.setViewName("/user/home");

		}
		else {
			modelAndView.setViewName("redirect:/user/login");

		}
		return modelAndView;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("/user/list");
		List<User> users = userService.list();
		
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name="id") Long id) {
		User user = userService.getOneUser(id);
		ModelAndView modelAndView = new ModelAndView("/user/edit");
		modelAndView.addObject("userForm",user);
		return modelAndView;
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView("/user/edit");
		modelAndView.addObject("userForm",new User());
		return modelAndView;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		user = userService.save(user);
		System.out.println(user.toString());
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		//modelAndView.addObject("userForm",user);
		return modelAndView;
	}
	@RequestMapping(value="/save",method=RequestMethod.PUT)
	public ModelAndView edit(@ModelAttribute User user) {
		user = userService.save(user);
		System.out.println("EDIT"+user.toString());
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		//modelAndView.addObject("userForm",user);
		return modelAndView;
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable(name="id") Long id) {
		//User user = userService.getOneUser(id);
		userService.delete(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
		//modelAndView.addObject("userForm",user);
		return modelAndView;
	}

}
