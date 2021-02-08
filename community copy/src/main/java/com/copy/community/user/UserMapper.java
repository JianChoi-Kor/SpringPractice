package com.copy.community.user;

import org.apache.ibatis.annotations.Mapper;

import com.copy.community.model.UserEntity;

@Mapper
public interface UserMapper {
	UserEntity selUser(UserEntity p);
	int insUser(UserEntity p);
}
