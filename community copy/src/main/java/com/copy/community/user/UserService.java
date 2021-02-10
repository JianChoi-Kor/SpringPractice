package com.copy.community.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copy.community.Const;
import com.copy.community.SecurityUtils;
import com.copy.community.model.UserEntity;

@Service
public class UserService {
	
	@Autowired
	UserMapper mapper;
	
	@Autowired
	SecurityUtils sUtils;
	
	
	public int chkId(UserEntity p) {
		UserEntity chkUserId = mapper.selUser(p);
		if(chkUserId != null) {
			return 1;
		}
		return 0;
	}
	
	public int join(UserEntity p) {
		if(chkId(p) == 0) {
			String salt = sUtils.getSalt();
			String hashPw = sUtils.getHashPw(p.getUserPw(), salt);
			
			p.setSalt(salt);
			p.setUserPw(hashPw);
			
			return mapper.insUser(p);
		} else {
			return 2;
		}
	}
	
	public int login(UserEntity p, HttpSession hs) {
		
		UserEntity loginUser = mapper.selUser(p);
		if(loginUser == null) {
			return 2; // 없는 아이디입니다.
		}
		
		String salt = loginUser.getSalt();
		String loginHashPw = sUtils.getHashPw(p.getUserPw(), salt);
		
		if(!loginHashPw.equals(loginUser.getUserPw())) {
			return 3; // 비밀번호가 틀립니다.
		}
		
		// 메모리에 올려둘 필요가 없다.
		loginUser.setUserPw(null);
		loginUser.setSalt(null);
		loginUser.setRegDt(null);
		
		// 실수를 막기 위해서 Const 클래스를 만들고 키값을 변수로 만들어서 사용한다.
		hs.setAttribute(Const.KEY_LOGINUSER, loginUser);
		return 1; // 로그인 성공했습니다.
	}
	
	
	
	
}
