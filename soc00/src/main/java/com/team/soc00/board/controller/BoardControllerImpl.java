package com.team.soc00.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc00.member.vo.MemberVO;
import com.team.soc00.board.service.BoardService;
import com.team.soc00.board.vo.ArticleVO;


@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;
	
	//해외축구게시판
	@Override
	@RequestMapping(value="/board/osSoccer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView osSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.osSoccerList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/osWrite.do", method=RequestMethod.POST)
	public String osWrite2(ArticleVO articleVO, HttpServletRequest req, HttpServletResponse res)throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		boardService.osWrite2(articleVO);
		return "redirect:/board/osSoccer.do";
	}
	
	/*
	 * @Override
	 * 
	 * @RequestMapping(value="/board/osView.do", method= {RequestMethod.POST,
	 * RequestMethod.GET}) public String osView(@RequestParam("no") int no, Model
	 * model, HttpServletRequest req, HttpServletResponse res)throws Exception {
	 * req.setCharacterEncoding("utf-8");
	 * res.setContentType("text/html; charset=utf-8"); int result =
	 * boardService.osView(no); model.addAttribute("views", result);
	 * System.out.println(result); return "redirect:/board/osView.do"; }
	 */
	
	@Override
	@RequestMapping(value="/board/osView.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView osView(@RequestParam("no") int no,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		articleVO = boardService.osView(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleVO);
		return mav;
	}
	
	/*
	 * @Override
	 * 
	 * @RequestMapping(value="/board/osWrite.do" ,method = RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseEntity osWrite(MultipartHttpServletRequest
	 * multipartRequest, HttpServletResponse response) throws Exception {
	 * multipartRequest.setCharacterEncoding("utf-8"); Map<String,Object> articleMap
	 * = new HashMap<String, Object>(); Enumeration
	 * enu=multipartRequest.getParameterNames(); while(enu.hasMoreElements()){
	 * String name=(String)enu.nextElement(); String
	 * value=multipartRequest.getParameter(name); articleMap.put(name,value); }
	 * 
	 * HttpSession session = multipartRequest.getSession(); MemberVO memberVO =
	 * (MemberVO) session.getAttribute("member"); String id = memberVO.getU_id();
	 * articleMap.put("no", 0); articleMap.put("u_id", id);
	 * 
	 * String message; ResponseEntity resEnt=null; HttpHeaders responseHeaders = new
	 * HttpHeaders(); responseHeaders.add("Content-Type",
	 * "text/html; charset=utf-8"); try { int articleNO =
	 * boardService.osWrite(articleMap);
	 * 
	 * 
	 * message = "<script>"; message += " alert('새글을 추가했습니다.');"; message +=
	 * " location.href='"+multipartRequest.getContextPath()+"/board/osSoccer.do'; ";
	 * message +=" </script>"; resEnt = new ResponseEntity(message, responseHeaders,
	 * HttpStatus.CREATED); }catch(Exception e) {
	 * 
	 * message = " <script>"; message +=" alert('오류가 발생했습니다. 다시 시도해 주세요');');";
	 * message +=" location.href='"+multipartRequest.getContextPath()
	 * +"/board/osWriteForm.do'; "; message +=" </script>"; resEnt = new
	 * ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	 * e.printStackTrace(); } return resEnt; }
	 */
	

	//국내축구게시판
	@Override
	@RequestMapping(value="/board/krSoccer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView krSoccer(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.krSoccerList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	//뉴스게시판
	@Override
	@RequestMapping(value="/board/news.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView news(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.newsList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	//자유게시판
	@Override
	@RequestMapping(value="/board/free.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView free(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List allList = boardService.freeList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allList", allList);
		return mav;
	}
	
	
	@RequestMapping(value="/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


}
