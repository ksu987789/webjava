package com.team.soc.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team.soc.board.service.BoardService;
import com.team.soc.board.dao.BoardDAO;
import com.team.soc.board.vo.ArticleVO;
import com.team.soc.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl  implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	public List<ArticleVO> listArticles() throws Exception{
		List<ArticleVO> articlesList =  boardDAO.selectArticlesList();
		return articlesList;
	}


	//단일 이미지 추가하기
	@Override
	public int newArticleAdd(Map articleMap) throws Exception{
		return boardDAO.insertArticle(articleMap);
	}



	//단일 파일 보이기
	@Override
	public ArticleVO articleView(int articleNO) throws Exception {
		ArticleVO articleVO = boardDAO.articleSelect(articleNO);
		return articleVO;
	}


	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.articleUpdate(articleMap);
	}

	@Override
	public void articleRemove(int articleNO) throws Exception {
		boardDAO.articleDelete(articleNO);
	}
}
