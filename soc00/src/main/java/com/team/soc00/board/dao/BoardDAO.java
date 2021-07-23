package com.team.soc00.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardDAO {

	public List osSoccerList() throws DataAccessException;
	public int osWrite(Map articleMap) throws DataAccessException;
	public ArticleVO selectOsSoccer(int articleNO) throws DataAccessException;
	public void updateOsSoccer(Map articleMap) throws DataAccessException;
	public void deleteOsSoccer(int articleNO) throws DataAccessException;
	public List krSoccerList() throws DataAccessException;
	public List newsList() throws DataAccessException;
	public List freeList() throws DataAccessException;
	public void osWrite2(ArticleVO articleVO) throws DataAccessException;
	public ArticleVO osView(int no) throws DataAccessException;
}
