package com.team.soc00.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.soc00.member.vo.MemberVO;

public interface MemberController {
	
	public ModelAndView userList(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView joinMember(@ModelAttribute("info") MemberVO memberVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
			RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView deleteMember(@RequestParam("u_id") String u_id,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView findId(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView modi(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public String userList2(Model model, HttpServletRequest req, HttpServletResponse res)throws Exception;
	

}