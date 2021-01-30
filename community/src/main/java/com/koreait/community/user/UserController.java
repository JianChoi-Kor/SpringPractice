package com.koreait.community.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.community.model.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public void login(Model model) {
		
	}
	
	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody UserEntity p, HttpSession hs) {
		System.out.println("id : "+ p.getUserId());
		System.out.println("pw : "+ p.getUserPw());
		
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.login(p, hs));
		
		return returnValue;
	}
	
	
//	@PostMapping("/login")
//	public String login(UserEntity p, HttpSession hs) {
//		System.out.println("id : "+ p.getUserId());
//		System.out.println("pw : "+ p.getUserPw());
//		int result = service.login(p, hs);
//		
//		if(result == 1) {
//			return "board/home";
//		} else {
//			return "redirect:/user/login?err=" + result;
//		}
//		
//	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@ResponseBody
	@PostMapping("/join")
	public Map<String, Object> join(@RequestBody UserEntity p) {
		System.out.println("id : "+ p.getUserId());
		System.out.println("pw : "+ p.getUserPw());
		
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.join(p));
		
		return returnValue;
	}
	
	@ResponseBody
	@GetMapping("/chkId/{userId}")
	public Map<String, Object> chkId(UserEntity p) {
		System.out.println("userId : "+ p.getUserId());
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", 1);
		returnValue.put("result", service.chkId(p)); // 아이디가 있으면1, 없으면 0 리턴
		
		return returnValue;
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "redirect:/user/login";
	}
	
	
	
}
