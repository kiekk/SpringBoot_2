package com.example.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Criteria {
	/* ���� ������ ��ȣ */
	private int pageNum;
	/* �� �������� ������ ������ �� */
	private int amount;
	
	/* �˻� ���� */
	private String type;
	/* �˻��� */
	private String keyword;
	
	/* �⺻ �� ���� */
	public Criteria() {
		this(1, 10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	/*
	 * �˻������� ���� ��� �� �迭, ���� ��� �� �ܾ�� split
	 */
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	public String makeQuery() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.type)
				.queryParam("keyword", this.keyword);
		
		return builder.toUriString();
	}
}
