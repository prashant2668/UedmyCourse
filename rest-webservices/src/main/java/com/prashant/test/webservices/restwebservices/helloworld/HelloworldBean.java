package com.prashant.test.webservices.restwebservices.helloworld;

public class HelloworldBean {
	
	private String msg;

	
	public HelloworldBean(String msg) {
		
		this.msg=msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloworldBean [msg=" + msg + "]";
	}
	
	
	

}
