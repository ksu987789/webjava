package com.team.soc01.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.team.soc01.board.vo.ArticleVO;

public interface BoardDAO {

	public List articleList() throws DataAccessException;
}
