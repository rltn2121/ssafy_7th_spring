package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw.dto.User;
import com.ssafy.hw.model.repo.UserRepo;

// 서비스 스캔을 위한 어노테이션
@Service
public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	
	// userRepo 주입
	@Autowired
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public UserRepo getUserRepo() {
		return this.userRepo;
	}
	
	// repo에 정의된 메소드를 그대로 사용
	@Override
	public int insert(User user) {
		return userRepo.insert(user);
	}

	@Override
	public int delete(String id) {
		return userRepo.delete(id);
	}

	@Override
	public int update(User user) {
		return userRepo.update(user);
	}

	@Override
	public User searchById(String id) {
		return userRepo.searchById(id);
	}

	@Override
	public List<User> selectAll() {
		return userRepo.selectAll();
	}

	@Override
	public List<User> searchByName(String name) {
		return userRepo.searchByName(name);
	}

}
