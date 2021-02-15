package com.example.service;

import com.example.domain.Criteria;
import com.example.domain.ReplyPageDTO;
import com.example.domain.ReplyVO;

public interface ReplyService {
	//��� ���
	public int register(ReplyVO reply);
	
	//��� ����
	public int modify(ReplyVO reply);
	
	//��� ����
	public int removeReply(Long rno);
	
	//��� ���
	public ReplyPageDTO getReplyList(Criteria cri, Long bno);
	
	//��� ��
	public ReplyVO getReply(Long rno);
	
	//��� �� ����
	public int getTotal(Long bno);
	
	//��� ��ü ����
	public int removeBoardReplys(Long bno);
}
