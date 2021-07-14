package com.team.soc01.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team.soc01.board.dao.BoardDAO;
import com.team.soc01.board.vo.ArticleVO;

@Service

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	public List<ArticleVO> articleList() throws Exception {
		List<ArticleVO> articlesList = boardDAO.articleList();
		return articlesList;
	}
}
