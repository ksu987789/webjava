package com.team.soc00.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.team.soc00.board.vo.ArticleVO;

public interface BoardDAO {

	public List osSoccerList() throws DataAccessException;
	public List krSoccerList() throws DataAccessException;
	public List newsList() throws DataAccessException;
	public List freeList() throws DataAccessException;
}
