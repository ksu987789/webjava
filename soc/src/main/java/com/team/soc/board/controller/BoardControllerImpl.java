package com.team.soc.board.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.team.soc.board.service.BoardService;
import com.team.soc.board.vo.ArticleVO;
import com.team.soc.board.vo.ImageVO;
import com.team.soc.member.vo.MemberVO;



@Controller("boardController")
public class BoardControllerImpl  implements BoardController{
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;

	@Override
	@RequestMapping(value= "/board/.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;

	}

	//?? ?? ?????? ??????
	@Override
	@RequestMapping(value="/board/newArticleAdd.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity osWrite(MultipartHttpServletRequest multipartRequest, 
			HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String,Object> articleMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			articleMap.put(name,value);
		}

		String imageFile= upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id = memberVO.getId();
		articleMap.put("parentNO", 0);
		articleMap.put("id", id);
		articleMap.put("imageFile", imageFile);

		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int articleNO = boardService.newArticleAdd(articleMap);
			if(imageFile!=null && imageFile.length()!=0) {
				File srcFile = new 
						File(ARTICLE_IMAGE_REPO+ "\\" + "temp"+ "\\" + imageFile);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				FileUtils.moveFileToDirectory(srcFile, destDir,true);
			}

			message = "<script>";
			message += " alert('?????? ????????????.');";
			message += " location.href='"+multipartRequest.getContextPath()+"/board/listArticles.do'; ";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFile);
			srcFile.delete();

			message = " <script>";
			message +=" alert('?????? ????????????. ???? ?????? ??????');');";
			message +=" location.href='"+multipartRequest.getContextPath()+"/board/articleForm.do'; ";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}


	//?????? ?????? ????????
	@RequestMapping(value="/board/articleView.do" ,method = RequestMethod.GET)
	public ModelAndView articleView(@RequestParam("articleNO") int articleNO,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		articleVO=boardService.articleView(articleNO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);
		return mav;
	}

	//?? ?? ?????? ???? ????
	@RequestMapping(value="/board/modArticle.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  
			HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String,Object> articleMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			articleMap.put(name,value);
		}

		String imageFile= upload(multipartRequest);
		articleMap.put("imageFile", imageFile);

		String articleNO=(String)articleMap.get("articleNO");
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modArticle(articleMap);
			if(imageFile!=null && imageFile.length()!=0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFile);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);

				String originalFileName = (String)articleMap.get("originalFileName");
				File oldFile = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originalFileName);
				oldFile.delete();
			}	
			message = "<script>";
			message += " alert('???? ????????????.');";
			message += " location.href='"+multipartRequest.getContextPath()+"/board/articleView.do?articleNO="+articleNO+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFile);
			srcFile.delete();
			message = "<script>";
			message += " alert('?????? ????????????.???? ????????????');";
			message += " location.href='"+multipartRequest.getContextPath()+"/board/articleView.do?articleNO="+articleNO+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	@Override
	@RequestMapping(value="/board/articleRemove.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity  articleRemove(@RequestParam("articleNO") int articleNO,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.articleRemove(articleNO);
			File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
			FileUtils.deleteDirectory(destDir);

			message = "<script>";
			message += " alert('???? ????????????.');";
			message += " location.href='"+request.getContextPath()+"/board/listArticles.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		}catch(Exception e) {
			message = "<script>";
			message += " alert('?????? ?????? ????????????.???? ?????? ??????.');";
			message += " location.href='"+request.getContextPath()+"/board/listArticles.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}  



	@RequestMapping(value = "/board/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	//???? ?????? ??????????
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		String imageFile= null;
		Iterator<String> fileNames = multipartRequest.getFileNames();

		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFile=mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+"\\" + fileName);
			if(mFile.getSize()!=0){ //File Null Check
				if(!file.exists()){ //???????? ?????? ???????? ???? ????
					file.getParentFile().mkdirs();  //?????? ???????? ???????????? ????
					mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+ "\\"+imageFile)); //?????? ?????? multipartFile?? ???? ?????? ????
				}
			}

		}
		return imageFile;
	}


}



