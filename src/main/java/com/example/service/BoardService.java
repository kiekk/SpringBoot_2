package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.LikeVO;

public interface BoardService {
	//��ü �Խñ� ��������, ����¡ ó��
	public List<BoardVO> getList(Criteria cri);
	
	//��ü �Խñ� ���� ��������
	public int getTotal(Criteria cri);
	
	//�Խñ� ��������
	public BoardVO get(BoardVO board);
	
	//�Խñ� ����
	public boolean modify(BoardVO board);
	
	//�Խñ� ���
	public void register(BoardVO board);
	
	//�Խñ� ����
	public boolean remove(Long bno);

	//��ȸ�� ����
	public void updateReadcount(Long bno);
	
	//���ƿ� ó��
	public int updateLike(LikeVO like);
	
	//���ƿ� ����
	public int getLikeCount(Long bno);
}
