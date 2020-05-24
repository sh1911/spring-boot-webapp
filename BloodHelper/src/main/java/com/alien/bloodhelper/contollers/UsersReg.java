package com.alien.bloodhelper.contollers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alien.bloodhelper.models.MailRequest;
import com.alien.bloodhelper.models.UserCredentials;
import com.alien.bloodhelper.repositry.UserRepositry;
import com.alien.bloodhelper.service.EmailService;
import com.alien.bloodhelper.service.UserDetailerServices;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import net.bytebuddy.asm.Advice.This;
@Controller
public class UsersReg  {
	
	@Value("${spring.mail.username}")
	private String fromid;
	@Autowired
	EmailService emailService;
	@Autowired
	UserCredentials user;
	@Autowired
	MailRequest mailRequest;
	@Autowired
	UserRepositry reposirty;
	@Autowired
	UserDetailerServices jpaReposirty;
	Map<String ,Object> model=new HashMap<>();
	Random rand=new Random();
	int potp;	
	public MailRequest setMailRequest(UserCredentials user,String subject)
	{
		this.mailRequest.setFromId(this.fromid);
		this.mailRequest.setToId(user.getEmail());
		this.mailRequest.setSubject(subject);
		return mailRequest;
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegisterForm()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user",user);
		modelAndView.setViewName("registerform"); 
		return modelAndView;
	}
	@PostMapping(value="/register")
	public ModelAndView setRegisterForm(@ModelAttribute("user") @Valid UserCredentials user,BindingResult result)
	{
		ModelAndView modelandview=new ModelAndView("otpform");
			if(result.hasErrors())
			{
				ModelAndView repopulateModelandview=new ModelAndView("registerform");
				System.out.print("error occured\n"+user);
				repopulateModelandview.addObject("user", user);
				return repopulateModelandview;
			}
			if (jpaReposirty.isUserExists(user.getEmail())==true) {
				System.out.print(jpaReposirty.isUserExists(user.getEmail()));
				this.user=user;
				System.out.println(user);
				this.potp=rand.nextInt(100000);
				System.out.println(potp);
				setMailRequest(this.user, "Verify One Time Password ");
				this.model.put("name",this.user.getFname()+this.user.getLname());
				this.model.put("otp",String.valueOf(potp));
				modelandview.addObject("mailresponse",emailService.sendEmail(mailRequest, model));
				return modelandview;
				
				
			}
			else
			{
		
				
				ModelAndView repopulateModelandview=new ModelAndView("home");
				repopulateModelandview.addObject("message","UserAlready exist");
				return repopulateModelandview;
			}
		}
		@RequestMapping("/resend")
		public ModelAndView resendOtp()
		{
			ModelAndView modelandview=new ModelAndView("otpform");
			this.potp=rand.nextInt(100000);
			System.out.println(potp);
			model.put("otp",potp);
			setMailRequest(this.user, "Verify One Time Password");
			modelandview.addObject("mailresponse",emailService.sendEmail(mailRequest, model));
			return modelandview;
			
		}
		@RequestMapping(value="/userAuth")
		public ModelAndView submitUserinfo(@RequestParam("otpstring") String otp)
		{
			
			
			System.out.println("The sent otp:"+potp+"The entred otp"+ otp);
			ModelAndView modelandview=new ModelAndView("login");
			if(this.potp==Integer.parseInt(otp))
			{
				System.out.print(this.user);
				user.setUserRole("USER");
				reposirty.save(user);
				modelandview.addObject("user",user);
			}
			else
				modelandview.addObject("user","otp not matched");
			return modelandview;
		}
		@RequestMapping("/home")
		public String home1()
		{
			
			return "home";
		}
		@GetMapping("/login")
		public String loginpage()
		{
			return "login";
		}
		@RequestMapping("/logout")
		public String logoutpage()
		{
			return "logout";
		}
		@RequestMapping("/login-success")
		public String loginsucpage()
		{
			return "login-sucess";
		}
}
