package com.alien.bloodhelper.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alien.bloodhelper.models.UserCredentials;
import com.alien.bloodhelper.models.UserDetailsPrinciple;
import com.alien.bloodhelper.repositry.UserRepositry;
import com.alien.bloodhelper.service.UserDetailerServices;

@RestController
@RequestMapping("/user")
public class SecuredContoller {
	@Autowired
	UserCredentials user;
	@Autowired
	UserDetailerServices jpaReposirty;
	@Autowired
	UserRepositry reposirty;
	private String loggedUser;
	ModelAndView modelAndView=new ModelAndView();
	@GetMapping("/updateUser")
	public ModelAndView updateCredentials()
	{
		String principle = SecurityContextHolder.getContext().getAuthentication().getName();
		this.loggedUser=principle;
		this.user=this.jpaReposirty.ifExists(loggedUser);
		this.modelAndView.setViewName("update");
		this.modelAndView.addObject("user",this.user);
		return modelAndView ;
		
	}
	@PostMapping("/saveUser")
	public ModelAndView SaveCredentials(@RequestParam("email") String email,@RequestParam("oldpassword") String oldPassword,@RequestParam("newpassword") String newPassword)
	{
		
		String message=null;
		String oldemail=null;
		if(this.user.getPassword().equals(oldPassword))
		{
			
			if(this.user.getEmail().equals(email)==false)
			{
				System.out.println(email+"\n");
				System.out.println("Boolean"+this.user.getEmail().equals(email));
				if (jpaReposirty.isUserExists(email)==true)
				{
					oldemail=this.user.getEmail();
					this.user.setEmail(email);
				}
				else
					if(message==null)
					message="User Already exists with this email !";
			}
				if(newPassword.isEmpty())
					newPassword=null;
				else
				{
					this.user.setPassword(newPassword);
				}		
		System.out.print("\nUpadted"+user);
		reposirty.save(this.user);
		System.out.println("email:"+oldemail+"::"+email+"\nPassword:"+oldPassword+"::"+newPassword);
		if((oldemail!=email&&oldemail!=null)||(newPassword!=oldPassword&&newPassword!=null))
			message="Updated Sucessfully ";
		else
			message="Hey Noting found for Update TryAgain";
		}
		
		else
			if(message==null)
			message="Password Incorrect";
		this.modelAndView.addObject("message",message);
		this.modelAndView.setViewName("update");
		return modelAndView;
	}
	
	
	

	

}
