package com.team.soc01.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc01.board.vo.ArticleVO;


@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List articleList()throws DataAccessException{
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.board.articleList");
		return articlesList;
	}
}
