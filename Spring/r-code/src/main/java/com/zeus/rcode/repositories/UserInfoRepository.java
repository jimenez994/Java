package com.zeus.rcode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.rcode.models.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	
	
}
