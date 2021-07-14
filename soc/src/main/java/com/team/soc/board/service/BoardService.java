package com.team.soc.board.service;

import java.util.List;
import java.util.Map;

import com.team.soc.board.vo.ArticleVO;

public interface BoardService {

	public List<ArticleVO> listArticles() throws Exception;
	public int newArticleAdd(Map articleMap) throws Exception;
	public ArticleVO articleView(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void articleRemove(int articleNO) throws Exception;
}
