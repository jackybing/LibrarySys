package com.zjb.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zjb.entity.User;
import com.zjb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getInfo/{userid}")
	public String getUserBasicInfo(@PathVariable Integer userid,ModelMap modelMap){
		User user=userService.get(userid);
		if(user!=null){
			modelMap.addAttribute("password",user.getPassword());
			modelMap.addAttribute("username",user.getUsername());
		}else {
			modelMap.addAttribute("user",null);
		}
		
		return "demo";
	}
	
	@RequestMapping("/getInfo")
	public String getUserBasicInfo2(@RequestParam Integer userid,ModelMap modelMap){
		User user=userService.load(userid);
		if(user!=null){
			modelMap.addAttribute("password",user.getPassword());
			modelMap.addAttribute("username",user.getUsername());
		}else {
			modelMap.addAttribute("user",null);
		}
		
		return "demo";
	}
	
}
