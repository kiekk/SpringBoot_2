package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
	/* �׷� ��ȣ */
	private int groupNo;
	/* �׷� ���� ���� */
	private int groupOrd;
	/* ���� */
	private int depth;
	/* ��� ��ȣ */
	private Long rno;
	/* �Խñ� ��ȣ */
	private Long bno;
	/* ��� ���� */
	private String reply;
	/* ��� �ۼ��� */
	private String replyer;
	/* ��� �ۼ��� */
	private String regDate;
	/* �θ��� */
	private Long parentRno;
}
