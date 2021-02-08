package com.copy.community.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
