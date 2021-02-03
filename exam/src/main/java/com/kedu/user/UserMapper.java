package com.kedu.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	int insUser(UserVo p);
	UserVo selUser(UserVo p);
	
	
}
