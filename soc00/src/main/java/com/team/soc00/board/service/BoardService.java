package com.team.soc00.board.service;

import java.util.List;
import java.util.Map;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardService {
	
	public List<ArticleVO> osSoccerList() throws Exception;

	public int osWrite(Map articleMap) throws Exception;
	
	public List<ArticleVO> krSoccerList() throws Exception;
	
	public List<ArticleVO> newsList() throws Exception;
	
	public List<ArticleVO> freeList() throws Exception;
	
	public void osWrite2(ArticleVO articleVO)throws Exception;
	
	public ArticleVO osView(int no)throws Exception;
}
