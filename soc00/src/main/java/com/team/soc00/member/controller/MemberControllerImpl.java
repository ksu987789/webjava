package com.team.soc00.member.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.soc00.HomeController;
import com.team.soc00.member.service.MemberService;
import com.team.soc00.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value= {"/", "/main.do"}, method=RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/userList.do", method = RequestMethod.GET)
	public ModelAndView userList(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		List membersList = memberService.userList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	
	}
	
	@Override
	@RequestMapping(value="/member/joinMember.do", method = RequestMethod.POST)
	public ModelAndView joinMember(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.joinMember(member);
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/deleteMember.do", method=RequestMethod.GET)
	public ModelAndView deleteMember(@RequestParam("u_id") String u_id,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.deleteMember(u_id);
		ModelAndView mav = new ModelAndView("redirect:/member/userList.do");
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member);
		if(memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main.do");
		}
		else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
	
	@RequestMapping(value="/member/*Form.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView form(@RequestParam(value = "result", required=false) String result,
							HttpServletRequest request, HttpServletResponse response)throws Exception {
		//String viewName = getViewName(request);//
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	
	@RequestMapping(value="/member/*pop.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pop(@RequestParam(value = "result", required=false) String result,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		//String viewName = getViewName(request);//
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/findId.do", method=RequestMethod.POST)
	public ModelAndView findId(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.findId(member); 
		request.setCharacterEncoding("utf-8");
		
		System.out.println(member);
		if(memberVO != null) {

			mav.addObject("member", memberVO);
			mav.setViewName("redirect:/member/findForm.do");
		
		}
		else {
			mav.setViewName("redirect:/member/findForm.do");
		}
		return mav;
	}

	
	@Override
	@RequestMapping(value="/member/modi.do", method=RequestMethod.POST)
	public ModelAndView modi(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.modi(member);
		ModelAndView mav = new ModelAndView("redirect:/member/userList.do");
		return mav;
		
	}
	
	private String getViewName(HttpServletRequest request)throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		
		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		}
		else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		}
		else {
			end = uri.length();
		}
		
		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.indexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
	
	@Override
	@Scheduled(cron="0/10 * * * * * ?")
	@RequestMapping(value="/list.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String userList2(Model model, HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		String batchResult = "성공";
		try {
			List membersList = memberService.userList();
			model.addAttribute("membersList", membersList);
		}
		catch(Exception e) {
			batchResult = "실패";
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("스케쥴 실행 : [" + batchResult + "] " + dateFormat.format(calendar.getTime()));
		return "/member/userList2"; 
		
	}

	
	/*
	 * @Scheduled(cron="0/10 * * * * * ?") public void scheduleRun() { String
	 * batchResult = "성공"; try { List<MemberVO> userList = memberService.userList();
	 * 
	 * } catch(Exception e) { batchResult = "실패"; }
	 * 
	 * Calendar calendar = Calendar.getInstance(); SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); logger.info("스케쥴 실행 : [" +
	 * batchResult + "] " + dateFormat.format(calendar.getTime())); }
	 */
}	