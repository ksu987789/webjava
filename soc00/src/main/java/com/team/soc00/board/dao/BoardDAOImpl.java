package com.team.soc00.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.board.vo.ArticleVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List osSoccerList()throws DataAccessException{
		List<ArticleVO> osSoccerList = osSoccerList = sqlSession.selectList("mapper.board.osSoccerList");
		return osSoccerList;
	}
	
	@Override
	public List krSoccerList()throws DataAccessException{
		List<ArticleVO> krSoccerList = krSoccerList = sqlSession.selectList("mapper.board.krSoccerList");
		return krSoccerList;
	}
	
	@Override
	public List newsList()throws DataAccessException{
		List<ArticleVO> newsList = newsList = sqlSession.selectList("mapper.board.newsList");
		return newsList;
	}
	
	@Override
	public List freeList()throws DataAccessException{
		List<ArticleVO> freeList = freeList = sqlSession.selectList("mapper.board.freeList");
		return freeList;
	}
}
