package com.wsq.webprj.vo;

import java.util.Date;

public class Comment {
	private String id;
	private String context;
	private Date regDate;
	private int debateCode;
	private String code;
	private boolean opinion;
		
		
	
	
	
	public boolean isOpinion() {
		return opinion;
	}
	public void setOpinion(boolean opinion) {
		this.opinion = opinion;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getDebateCode() {
		return debateCode;
	}
	public void setDebateCode(int debateCode) {
		this.debateCode = debateCode;
	}
	
	
	
}
