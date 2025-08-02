package com.myedu.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myedu.myapp.model.CommentVO;
import com.myedu.myapp.model.ContentVO;
import com.myedu.myapp.model.Query;
import com.myedu.myapp.service.IBoardService;

@Controller
public class BoardController {
	
	@Autowired
	IBoardService boardService;
	
	@GetMapping("/main/main")
	public String main() {
		return "/main/main";
	}
	
	@RequestMapping("/board")
	public String contentList(Query query, Model model) {
		if (query.getPage()==0) query.setPage(1);
		if (query.getQuerySelect()==null) query.setQuerySelect("all");
		if (query.getOrderSelect()==null) query.setOrderSelect("add_date desc");
		
		model.addAttribute("query", query);
		model.addAttribute("resultContent", boardService.listContent(query));
		model.addAttribute("commentNumbers", boardService.getCommentNumbers(query));
		return "/board/board-list";
	}
	
	@GetMapping("/board/read")
	public String contentRead(@RequestParam("contentId")int contentId, Model model) {
		boardService.incrementViewCountContent(contentId);
		model.addAttribute("content", boardService.getContent(contentId));
		model.addAttribute("comments", boardService.getParentComments(contentId));
		model.addAttribute("nextContent", boardService.getNextContent(contentId));
		model.addAttribute("prevContent", boardService.getPrevContent(contentId));
		return "/board/board-read";
	}
	
	@GetMapping("/board/write")
	public String contentWrite() {
		return "/board/board-write";
	}
	
	@PostMapping("/board/write")
	public String contentWrite(ContentVO content, Model model) {
		try {
			boardService.insertContent(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board";
	}
	
	@GetMapping("/board/update")
	public String contentUpdate(@RequestParam("contentId")int contentId, Model model) {
		model.addAttribute("content", boardService.getContent(contentId));
		model.addAttribute("contentId", contentId);
		return "/board/board-update";
	}
	
	@PostMapping("/board/update")
	public String contentUpdate(ContentVO content, Model model) {
		try {
			boardService.updateContent(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/read?contentId="+content.getContentId();
	}
	
	@GetMapping("/board/delete")
	public String contentDelete(@RequestParam("contentId")int contentId) {
		try {
			boardService.deleteContent(contentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board";
	}
	
	@PostMapping("/comment/write")
	public String commentWrite(@RequestParam("contentId")int contentId, CommentVO comment) {
		try {
			boardService.insertComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/read?contentId="+contentId;
	}
	@PostMapping("/comment/cwrite")
	public String commentCWrite(@RequestParam("contentId")int contentId, CommentVO comment) {
		try {
			boardService.insertChildComment(comment.getParentId(), comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/read?contentId="+contentId;
	}
	
	@PostMapping("/comment/update")
	public String commentUpdate(@RequestParam("contentId")int contentId, CommentVO comment) {
		try {
			boardService.updateComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/read?contentId="+contentId;
	}
	
	@PostMapping("/comment/delete")
	public String commentDelete(@RequestParam("commentId")int commentId,
								@RequestParam("contentId")int contentId) {
		try {
			boardService.deleteComment(commentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/read?contentId="+contentId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
