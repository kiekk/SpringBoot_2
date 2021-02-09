package com.example.mapper;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {
	
	/*
	 * �ؾ� �� ��
	 * �Խñ� ��Ͻ� �Խñ� ��ȣ ������ �� ����ϱ�
	 */
	
	/* �Խñ� �󼼺��� */
	public BoardVO getBoard(Long bno);
	
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
}
