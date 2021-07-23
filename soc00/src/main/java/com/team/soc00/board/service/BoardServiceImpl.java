package com.team.soc00.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team.soc00.board.dao.BoardDAO;
import com.team.soc00.board.vo.ArticleVO;

@Service("boardService")

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	public List<ArticleVO> osSoccerList() throws Exception {
		List<ArticleVO> osSoccerList = boardDAO.osSoccerList();
		return osSoccerList;
	}
	
	public void osWrite2(ArticleVO articleVO)throws Exception {
		boardDAO.osWrite2(articleVO);
	}
	
	@Override
	public int osWrite(Map articleMap) throws Exception{
		return boardDAO.osWrite(articleMap);
	}
	
	public List<ArticleVO> krSoccerList() throws Exception {
		List<ArticleVO> krSoccerList = boardDAO.krSoccerList();
		return krSoccerList;
	}
	
	public List<ArticleVO> newsList() throws Exception {
		List<ArticleVO> newsList = boardDAO.newsList();
		return newsList;
	}
	
	public List<ArticleVO> freeList() throws Exception {
		List<ArticleVO> freeList = boardDAO.freeList();
		return freeList;
	}
	
	public ArticleVO osView(int no)throws Exception{
		return boardDAO.osView(no);
	}
	
}
