package com.zeus.rcode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.rcode.models.UserInfo;
import com.zeus.rcode.repositories.UserInfoRepository;

@Service
public class UserInfoServices {
	
	@Autowired
	private UserInfoRepository userInfoRepo;
	
	public UserInfo getUserInfo(Long id) {
		return userInfoRepo.findOne(id);
	}
	
	public void addUserInfo(UserInfo userInfo) {
		userInfoRepo.save(userInfo);
	}
	
	public void deleteUserInfo(Long id) {
		userInfoRepo.delete(id);
	}

}
