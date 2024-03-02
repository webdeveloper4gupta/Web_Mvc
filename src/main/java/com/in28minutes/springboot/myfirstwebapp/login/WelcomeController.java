package com.in28minutes.springboot.myfirstwebapp.login;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
//here i write the code for the session 
//@SessionAttributes("name")
public class WelcomeController {
//	way of adding the logging in the application
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	
	
	
//	Here I make the web page for the login
	
//	here i write the code for explainging the concept of taking the input from the url
//	@RequestMapping("login")
//	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
//	to send the data from the controller to the views(jsp)
//		model.put("name", name);
//	here i print the name in the commandline
//		logger.debug("ReQUEST PARAM IS {}",name);
//		logger.info("info level things ");
//		logger.warn("I want this print at warn level");
//		System.out.println("request param is :"+name); // not recommend use sys in the production code
//	here i return the 
//		return "login";
//	}
	
	
	
	
	
	
//	@RequestMapping("login") //it handle the both method ---> get,post
//	public String gotoLoginPage() {
//	
//		
//		return "login";
//	}
	
	
	
	
	
	
	
//	here i write the authentication class object 
	
//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}


//	@RequestMapping(value="login",method=RequestMethod.GET) //for handling specific method
//	public String gotoLoginPage() {
//		return "login";
//	}
	
//	here i write the concept that login handle by spring security
	@RequestMapping(value="/",method=RequestMethod.GET) //for handling specific method
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
//	use to remove the hardcode name 
	private String getLoggedinUsername() {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
//	@RequestMapping(value="login",method=RequestMethod.POST) //for handling specific method
//	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
//		model.put("name", name);
//		model.put("password", password);
//		return "welcome";
//	}
	
	
//	now i explain the concept of the hardcoded validation
//	@RequestMapping(value="login",method=RequestMethod.POST) //for handling specific method
//	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
//		
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//			
////			Authentication
////			name--in28minutes 
////			password--dummy
//			return "welcome";
//		} 
//		model.put("errorMessage", "Invalid Credentials");
//		return "login";
//	
//	}
}
