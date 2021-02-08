package com.koreait.community.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.community.Const;
import com.koreait.community.SecurityUtils;
import com.koreait.community.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private SecurityUtils sUtils;

	public int join(UserEntity p) {
		if (p.getUserId() == null || p.getUserId().length() < 2) {
			return 0;
		}
		
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

	// 1 : 로그인 성공, 2 : 아이디 없음, 3 : 비밀번호가 틀림, 0 : 에러
	public int login(UserEntity p, HttpSession hs) {

		UserEntity loginUser = mapper.selUser(p);
		if(loginUser == null) {
			return 2;
		}
		
		String salt = loginUser.getSalt();
		String loginHashPw = sUtils.getHashPw(p.getUserPw(), salt);
		
		if(!loginHashPw.equals(loginUser.getUserPw())) {
			return 3;
		}
		
		// 메모리에 올려둘 필요가 없다.
		loginUser.setUserPw(null);
		loginUser.setSalt(null);
		loginUser.setRegDt(null);
		
		// 실수를 막기 위해서 Const 클래스를 만들고 아래와 같이 저장
		hs.setAttribute(Const.KEY_LOGINUSER, loginUser);
		return 1;
	}
	
	public int chkId(UserEntity p) {
		UserEntity chkUserId = mapper.selUser(p);
		if(chkUserId != null) {
			return 1;
		}
		return 0;
	}
	
	
}
