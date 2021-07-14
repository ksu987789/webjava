package com.team.soc01.board.service;

import java.util.List;
import java.util.Map;

import com.team.soc01.board.vo.ArticleVO;

public interface BoardService {
	
	public List<ArticleVO> articleList() throws Exception;
}
