package com.alien.bloodhelper.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alien.bloodhelper.models.UserCredentials;
import com.alien.bloodhelper.service.UserDetailerServices;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private String adminUser;
	@Autowired
	UserCredentials user;
	@Autowired
	UserDetailerServices jpaReposirty;
	ModelAndView modelAndView=new ModelAndView();
	@GetMapping("/")
	public ModelAndView getAdmin()
	{
		String principle = SecurityContextHolder.getContext().getAuthentication().getName();
		this.adminUser=principle;
		this.user=this.jpaReposirty.ifExists(this.adminUser);
		if(this.user.getUserRole()=="ADMIN")
		{
			this.modelAndView.addObject("user",this.user);
			modelAndView.setViewName("admin");
		}
		return modelAndView;
	}
	
	
}
