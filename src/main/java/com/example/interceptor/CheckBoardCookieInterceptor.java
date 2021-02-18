package com.example.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.example.service.BoardService;

import lombok.Setter;

public class CheckBoardCookieInterceptor extends HandlerInterceptorAdapter {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService b_service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie boardCookie = WebUtils.getCookie(request, "boardCookie");
		String bno = request.getParameter("bno");
		
		//����, ���� �Խñ۷� �̵����� ��� ������ �Խñ� ��Ű�� ����
		if(boardCookie != null && !boardCookie.getValue().equals(bno)) {
			boardCookie.setMaxAge(0);
			response.addCookie(boardCookie);
		}
		
		if(boardCookie == null) {
			b_service.updateReadcount(Long.parseLong(bno));
			response.addCookie(new Cookie("boardCookie", bno));
		}
		
		return true;
	}
}
