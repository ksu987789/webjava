package com.team.soc01.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ArticleVO {
	
	private int s1_no;
	private String s1_title;
	private String s1_content;
	private String s1_category;
	private Date s1_regdate;
	private int s1_view;
	private String u_id;
	
	public ArticleVO() {
		System.out.println("s1_no ");
	}

	
	public int getS1_no() {
		return s1_no;
	}
	
	public void sets1_no(int s1_no) {
		this.s1_no = s1_no;
	}
	
	public String getS1_title() {
		return s1_title;
	}
	
	public void sets1_title(String s1_title) {
		this.s1_title = s1_title;
	}
	
	public String gets1_content() {
		return s1_content;
	}
	
	public void sets1_content(String s1_content) {
		this.s1_content = s1_content;
	}
	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	public Date gets1_regdate() {
		return s1_regdate;
	}
	
	public void sets1_regdate(Date s1_regdate) {
		this.s1_regdate = s1_regdate;
	}
	
	public int getS1_view() {
		return s1_view;
	}
	
	public void setS1_view(int s1_view) {
		this.s1_view = s1_view;
	}
}
