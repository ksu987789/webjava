package com.team.soc.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.team.soc.member.vo.MemberVO;

public interface MemberService {

	public List userList() throws DataAccessException;
	public int joinMember(MemberVO memberVO)throws DataAccessException;


	public int memberRemove(String id) throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws Exception;
}
