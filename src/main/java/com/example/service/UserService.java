package com.example.service;

import com.example.domain.UserVO;

public interface UserService {
	
	//�ߺ� Ȯ��
	public int checkId(String id);
	
	//ȸ�� ����
	public int register(UserVO user);
	
	//�α���
	public UserVO login(UserVO user);
}
