package com.bit2015.mybatisexample.vo;

public class GuestbookVo {
	private Long no;
	private String name;
	private String message;
	private String password;
	private String reg_date;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegDate() {
		return reg_date;
	}

	public void setRegDate(String regDate) {
		this.reg_date = regDate;
	}

	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", message="
				+ message + ", password=" + password + ", regDate=" + reg_date
				+ "]";
	}
}