package com.team.soc00.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.team.soc00.member.vo.MemberVO;

public interface MemberDAO {

	public List selectAllUser() throws DataAccessException;
	public int joinMember(MemberVO memberVO)throws DataAccessException;
	public int deleteMember(String u_id)throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
	public MemberVO findId(MemberVO	memberVO)throws DataAccessException;
	public int modi(MemberVO memberVO)throws DataAccessException;
}
