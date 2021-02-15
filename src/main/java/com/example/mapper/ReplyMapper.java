package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Criteria;
import com.example.domain.ReplyVO;

public interface ReplyMapper {
	//��� ���
	public int insert(ReplyVO reply);
	
	//��� ����
	public int update(ReplyVO reply);
	
	//��� ����
	public int deleteReply(Long rno);
	
	//��� ���
	public List<ReplyVO> getReplyList(@Param("cri") Criteria cri,@Param("bno") Long bno);
	
	//��� ��
	public ReplyVO getReply(Long rno);
	
	//��� �� ����
	public int getTotal(Long bno);
	
	//��� ��ü ����
	public int deleteBoardReplys(Long bno);
}
