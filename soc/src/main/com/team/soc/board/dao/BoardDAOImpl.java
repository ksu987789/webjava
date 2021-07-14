package com.team.soc.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc.board.vo.ArticleVO;
import com.team.soc.board.vo.ImageVO;

public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectArticlesList() throws DataAccessException {
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}


	@Override
	public int insertArticle(Map articleMap) throws DataAccessException {
		int articleNO = newArticleNOSelect();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mapper.board.insertNewArticle",articleMap);
		return articleNO;
	}


	@Override
	public ArticleVO articleSelect(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.articleSelect", articleNO);
	}

	@Override
	public void articleUpdate(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.articleUpdate", articleMap);
	}

	@Override
	public void articleDelete(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.articleDelete", articleNO);

	}

	@Override
	public List imageFileListSelect(int articleNO) throws DataAccessException {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.imageFileListSelect",articleNO);
		return imageFileList;
	}

	private int newArticleNOSelect() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.newArticleNOSelect");
	}

	private int newImageFileNOSelect() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.newImageFileNOSelect");
	}

}
