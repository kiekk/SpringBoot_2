package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardVO {
	/* �׷� ��ȣ */
	private int groupNo;
	/* �׷� ���� ���� */
	private int groupOrd;
	/* ���� */
	private int depth;
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
