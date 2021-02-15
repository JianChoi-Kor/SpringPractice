package com.koreait.community.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.community.Const;
import com.koreait.community.FileUtils;
import com.koreait.community.SecurityUtils;
import com.koreait.community.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private SecurityUtils sUtils;
	
	@Autowired
	private FileUtils fUtils;

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
		loginUser.setProfileImg(null);
		
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
	
	public UserEntity selUser(UserEntity p) {
		return mapper.selUser(p);
	}
	
	public int uploadProfile(MultipartFile mf, HttpSession hs) {
		int userPk = sUtils.getLoginUserPk(hs);
		
		if(userPk == 0 || mf == null) { // 로그인이 안 되어 있는 경우, 파일이 없는 경우
			return 0;
		}
		
		String folder = "/res/img/user/" + userPk;
		String profileImg = fUtils.transferTo(mf, folder);
		
		if(profileImg == null) { // 파일 생성 실패
			return 0;
		}
		
		
		UserEntity p = new UserEntity();
		p.setUserPk(userPk);
		
		
		
		// 기존 이미지가 존재했다면 이미지 삭제
		UserEntity userInfo = mapper.selUser(p);
		if(userInfo.getProfileImg() != null) {
			String basePath = fUtils.getBasePath(folder);
			File file = new File(basePath, userInfo.getProfileImg());
			if(file.exists()) {
				file.delete();
			}
		}
				
				
		p.setProfileImg(profileImg);
		
		return mapper.updUser(p);
	}
	
	
}
