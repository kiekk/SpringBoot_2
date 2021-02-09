package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PageDTO {
	/* ���� ������ */
	private int startPage;
	/* �� ������ */
	private int endPage;
	/* ������ �Խñ��� �ִ� ������ */
	private int realEnd;
	/* ����, ���� ������ ���� */
	private boolean prev, next;
	/* �� �Խñ� ���� */
	private int total;
	/* Criteria ��ü */
	private Criteria cri;
	
	/*
	 * Criteria ��ü�� �̿��Ͽ� ����¡�� �ʿ��� ���� ó��
	 */
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) Math.ceil(cri.getPageNum() / (float)cri.getAmount()) * 10;
		this.startPage = this.endPage - 9;
		
		this.realEnd = (int) Math.ceil((total * 1.0) / cri.getAmount());
		
		if(realEnd < this.endPage)
			this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
