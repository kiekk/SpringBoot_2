package com.example.domain;

import lombok.Data;

@Data
public class BoardVO {
	/* �׷� ��ȣ */
	private int groupNo;
	/* �׷� ���� ���� */
	private int groupOrd;
	/* ���� */
	private int depth;
	/* �θ� �Խñ� ��ȣ */
	private Long parentBno;
	/* �Խñ� ��ȣ */
	private Long bno;
	/* �Խñ� ���� */
	private String title;
	/* �Խñ� ���� */
	private String content;
	/* �ۼ��� */
	private String writer;
	/* �ۼ��� */
	private String regDate;
}
