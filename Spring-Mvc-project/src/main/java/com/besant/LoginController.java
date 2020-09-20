package com.besant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		logger.info("Hello I am inside the login method");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLogin(ModelMap model,@RequestParam String name,
			@RequestParam String password) {
		logger.info("Hello I am inside the login method-post before loading welcome page");
		if(loginService.validateUser(name, password)) {
		return "welcome";
		}
		else
		{
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
	}
	
	
	@RequestMapping(value = "/ourOwn", method = RequestMethod.GET)
	public String ourOwnPage() {
		return "ourOwnHtmlPage";
	}
	
	@RequestMapping(value = "/ourOwn2", method = RequestMethod.GET)
	public String ourOwnPage2() {
		return "ourOwnHtmlPage2";
	}
}

