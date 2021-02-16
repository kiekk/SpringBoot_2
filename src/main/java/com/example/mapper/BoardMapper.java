package com.example.mapper;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.LikeVO;

public interface BoardMapper {
	
	/*
	 * �ؾ� �� ��
	 * �Խñ� ��Ͻ� �Խñ� ��ȣ ������ �� ����ϱ�
	 */
	
	/* �Խñ� �󼼺��� */
	public BoardVO getBoard(BoardVO board);
	
	/* �Խñ� ��� �������� */
	public List<BoardVO> getListAll(Criteria cri);
	
	/* �Խñ� �� ���� �������� */
	public int getTotal(Criteria cri);
	
	/* �Խñ� ��� */
	//public void insert(BoardVO board);
	public void insertSelectKey_bno(BoardVO board);
	
	/* �Խñ� ���� */
	public int delete(Long bno);
	
	/* �Խñ� ���� */
	public int update(BoardVO board);
	
	/* �Խñ� groupNo, depth ���� */
	public void updateGroupNoAndDepth(BoardVO board);
	
	/* ��ȸ�� ���� */
	public void updateReadcount(Long bno);
	
	/* ���ƿ� ó�� */
	public int insertLike(LikeVO like);
	
	/* ���ƿ� ��� */
	public int deleteLike(LikeVO like);
	
	/* ���ƿ� ���� �������� */
	public int getLikeCount(LikeVO like);
}
