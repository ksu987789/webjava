package com.team.soc00.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.team.soc00.member.dao.MemberDAO;
import com.team.soc00.member.vo.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List userList()throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllUser();
		return membersList;
	}
	
	@Override
	public int joinMember(MemberVO member) throws DataAccessException {
		return memberDAO.joinMember(member);
	}
	
	@Override
	public int deleteMember(String u_id)throws DataAccessException {
		return memberDAO.deleteMember(u_id);
	}
	
	@Override
	public MemberVO login(MemberVO memberVO)throws Exception{
		return memberDAO.login(memberVO);
	}
	
	@Override
	public MemberVO findId(MemberVO memberVO)throws DataAccessException {
		return memberDAO.findId(memberVO);
	}
	
	@Override
	public int modi(MemberVO memberVO)throws DataAccessException {
		return memberDAO.modi(memberVO);
	}
}
