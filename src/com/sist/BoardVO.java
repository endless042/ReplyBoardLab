package com.sist;
/*
NO         NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(34)   
EMAIL               VARCHAR2(50)   
SUBJECT    NOT NULL VARCHAR2(4000) 
CONTENT    NOT NULL CLOB           
PWD        NOT NULL VARCHAR2(10)   
REGDATE             DATE           
HIT                 NUMBER         
GROUP_ID            NUMBER         
GROUP_STEP          NUMBER         
GROUP_TAB           NUMBER         
DEPTH               NUMBER         
ROOT                NUMBER         

 * 
 */
import java.util.*;
public class BoardVO {

	private int no;		//primary key
	private String name;
	private String email;
	private String subject;
	private String content;
	private String pwd;
	private Date regdate;
	private int hit;
	private int group_id;
	private int group_tab;
	private int depth;
	private int root;
	
	private int rownum;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getGroup_tab() {
		return group_tab;
	}

	public void setGroup_tab(int group_tab) {
		this.group_tab = group_tab;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	
}
