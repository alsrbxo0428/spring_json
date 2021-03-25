package org.ict.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVO {
	private int mno;
	private String mid;
	private String pwd;
	private String name;
	private String pcode;
	private String addr1;
	private String addr2;
	private String tel1;
	private String tel2;
	private String tel3;
	private Date regdate;
}
