package com.team.soc00.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {
	
	private int no;
	private String title;
	private String content;
	private String category;
	private Date regdate;
	private int view;
	private String u_id;
	
	public ArticleVO() {
		
	}
	
	public ArticleVO(int no, String title, String content, String category, Date regdate, int view, String u_id) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.category = category;
		this.regdate = regdate;
		this.view = view;
		this.u_id = u_id;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public int getView() {
		return view;
	}
	
	public void setView(int view) {
		this.view = view;
	}
}
