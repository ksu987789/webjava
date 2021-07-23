package com.team.soc00.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.team.soc00.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllUser()throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllUser");
		return membersList;
	}
	
	@Override
	public int joinMember(MemberVO memberVO)throws DataAccessException {
		int result = sqlSession.insert("mapper.member.joinMember", memberVO);
		return result;
	}
	
	@Override
	public int deleteMember(String u_id)throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", u_id);
		return result;
	}
	
	@Override
	public MemberVO login(MemberVO memberVO)throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.login", memberVO);
		return vo;
	}
	
	@Override
	public MemberVO findId(MemberVO memberVO)throws DataAccessException {
		MemberVO result = sqlSession.selectOne("mapper.member.findId", memberVO);
		return result;
	}
	
	@Override
	public int modi(MemberVO memberVO)throws DataAccessException {
		int result = sqlSession.update("mapper.member.updateUser", memberVO);
		return result;
	}
}
