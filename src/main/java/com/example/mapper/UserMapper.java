package com.example.mapper;

import com.example.domain.UserVO;

public interface UserMapper {
	//�ߺ� Ȯ��
	public int checkId(String id);
	
	//ȸ�� ����
	public int insert(UserVO user);
	
	//�α���
	public int login(UserVO user);
}
