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
}
