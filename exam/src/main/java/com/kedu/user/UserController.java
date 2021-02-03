package com.kedu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(UserVo p) {
		System.out.println("uid : "+p.getUid());
		System.out.println("upw : "+p.getUpw());
		
		UserVo data = service.selUser(p);
		
		if(data.getUpw().equals(p.getUpw())) {
			return "/user/home";
		}
		return "/user/login";
	}
	
	
	@GetMapping("/join")
	public void join() {

	}
	
	@PostMapping("/join")
	public void join(UserVo p) {
		System.out.println("uid : "+p.getUid());
		System.out.println("upw : "+p.getUpw());
		System.out.println("nm : "+p.getNm());
		
		service.insUser(p);
	}
	
	@GetMapping("/home")
	public void home() {
		
	}

	
}
