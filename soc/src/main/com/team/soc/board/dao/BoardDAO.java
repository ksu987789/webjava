package com.team.soc.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.team.soc.board.vo.ArticleVO;

public interface BoardDAO {

	public List selectArticlesList() throws DataAccessException;
	public int insertArticle(Map articleMap) throws DataAccessException;

	public ArticleVO articleSelect(int articleNO) throws DataAccessException;
	public void articleUpdate(Map articleMap) throws DataAccessException;
	public void articleDelete(int articleNO) throws DataAccessException;
	public List imageFileListSelect(int articleNO) throws DataAccessException;
}
