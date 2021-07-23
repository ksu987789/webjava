package com.team.soc00.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardController {

	public ModelAndView osSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception;

	/*
	 * public ResponseEntity osWrite(MultipartHttpServletRequest
	 * multipartRequest,HttpServletResponse response) throws Exception;
	 */
	public ModelAndView krSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView news(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView free(HttpServletRequest request, HttpServletResponse response)throws Exception;

	public String osWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	public ModelAndView osView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
}
