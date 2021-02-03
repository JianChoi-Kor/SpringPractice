package com.kedu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public int insUser(UserVo p) {
		return mapper.insUser(p);
	}
	
	public UserVo selUser(UserVo p) {
		return mapper.selUser(p);
	}
	
//	public int selUser(UserVo p) {
//		UserVo dbData = mapper.selUser(p);
//		
//		if(dbData == null) {
//			return 2; // 아이디 없음
//		}
//		String dbPw = dbData.getUpw();
//		String currentPw = p.getUpw();
//		
//		if(!dbPw.equals(currentPw)) {
//			return 3; // 비밀번호 틀림
//		}
//		return 1; // 로그인 성
//	}
}
