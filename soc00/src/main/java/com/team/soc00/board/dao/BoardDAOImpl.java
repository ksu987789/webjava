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
		List<ArticleVO> osSoccerList = sqlSession.selectList("mapper.board.osSoccerList");
		return osSoccerList;
	}
	
	@Override
	public void osWrite2(ArticleVO articleVO) throws DataAccessException {
		sqlSession.insert("mapper.board.insertOsSoccer", articleVO);
	}
	
	@Override
	public ArticleVO osView(int no) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectOsView", no);
	}
	
	@Override
	public int osWrite(Map articleMap) throws DataAccessException{
		int No = selectOsSoccerNO();
		articleMap.put("no", No);
		sqlSession.insert("mapper.board.insertOsSoccer",articleMap);
		return No;
	}
	
	@Override
	public ArticleVO selectOsSoccer(int no) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectOsSoccer", no);
	}

	@Override
	public void updateOsSoccer(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateOsSoccer",articleMap);
	}

	@Override
	public void deleteOsSoccer(int no) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteOsSoccer",no);
		
	}
	
	@Override
	public List krSoccerList()throws DataAccessException{
		List<ArticleVO> krSoccerList = sqlSession.selectList("mapper.board.krSoccerList");
		return krSoccerList;
	}
	
	@Override
	public List newsList()throws DataAccessException{
		List<ArticleVO> newsList = sqlSession.selectList("mapper.board.newsList");
		return newsList;
	}
	
	@Override
	public List freeList()throws DataAccessException{
		List<ArticleVO> freeList = sqlSession.selectList("mapper.board.freeList");
		return freeList;
	}
	
	private int selectOsSoccerNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.board.selectOsSoccerNO");
	}
}
