package com.itheima.service;

import com.ithiema.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void saveUser(UserInfo userInfo);

    UserInfo findById(String id);
}
