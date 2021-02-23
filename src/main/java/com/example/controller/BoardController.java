package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.LikeVO;
import com.example.domain.PageDTO;
import com.example.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService b_service;
	
	//�Խñ� ��� ������
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("BoardController.list(GET)");
		model.addAttribute("list", b_service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, b_service.getTotal(cri)));
	}
	
	//�Խñ� ��� ������
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri, @ModelAttribute("board") BoardVO board) {
		log.info("BoardController.register(GET)");
	}
	
	//�Խñ� �󼼺���, ���� ������
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		log.info("BoardController.get(GET)");
		String sessionId = (String) session.getAttribute("user");
		LikeVO like = new LikeVO();
		like.setBno(bno);
		like.setWriter(sessionId); //���ƿ� ���������� ���� Ȯ�ο� ���̵�
		model.addAttribute("board", b_service.get(like));
		model.addAttribute("prevBoard", b_service.getPrevBoard(bno));
		model.addAttribute("nextBoard", b_service.getNextBoard(bno));
	}
	
	//�Խñ� ��� ó��
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.register(POST)");
		b_service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	//�Խñ� ���� ó��
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		log.info("BoardController.modify(POST)");
		rttr.addFlashAttribute("result", b_service.modify(board) ? "success" : "fail");
		return "redirect:/board/get" + cri.makeQuery() + "&bno=" + board.getBno();
	}
	
	//�Խñ� ���� ó��
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
		log.info("BoardController.remove(POST)");
		rttr.addFlashAttribute("result", b_service.remove(bno) ? "success" : "fail");
		return "redirect:/board/list" + cri.makeQuery();
	}
	
	//�Խñ� ���ƿ� ó��
	@PostMapping("/board/like")
	public ResponseEntity<Integer> updateLike(@RequestParam("bno") Long bno, HttpSession session){
		log.info("BoardController.updateLike(POST)");
		String sessionId = (String) session.getAttribute("user");
		log.info("SessionId : " + sessionId);
		LikeVO like = new LikeVO();
		like.setBno(bno);			//�Խñ� ��ȣ
		like.setWriter(sessionId);	//���� ���̵�
		int result = b_service.updateLike(like);
		
		return result == 1 ? new ResponseEntity<Integer>(b_service.getLikeCount(bno), HttpStatus.OK) : 
			new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
