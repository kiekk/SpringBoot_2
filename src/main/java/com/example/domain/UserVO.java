package com.example.domain;

import lombok.NoArgsConstructor;

import lombok.ToString;

import lombok.Setter;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserVO {
	/* ���̵� */
	private String id;
	/* ��й�ȣ */
	private String password;
	/* �̸� */
	private String name;
	/* ��ȭ��ȣ */
	private String phone;
	/* �̸��� */
	private String email;
	/* �ּ� */
	private String address;
	/* �� �ּ� */
	private String address_detail;
}
