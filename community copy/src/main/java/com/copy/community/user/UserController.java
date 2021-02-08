package com.copy.community.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.copy.community.model.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/home")
	public void home() {
		
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@ResponseBody
	@PostMapping("/join")
	public Map<String, Object> join(@RequestBody UserEntity p) {
		System.out.println("id : " + p.getUserId());
		System.out.println("pw : " + p.getUserPw());
		
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.join(p));
		
		return returnValue;
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@ResponseBody
	@GetMapping("/chkId/{userId}")
	public Map<String, Object> chkId(UserEntity p) {
		System.out.println("userId : " + p.getUserId());
		
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.chkId(p));
		
		return returnValue;
	}
	
}
