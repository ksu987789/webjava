package com.team.soc00.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.team.soc00.member.vo.MemberVO;

public interface MemberDAO {

	public List selectAllUser() throws DataAccessException;
	public int joinMember(MemberVO memberVO)throws DataAccessException;


	public int deleteMember(String id) throws DataAccessException;
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
}
