package com.jingchen.pulltorefresh.bean;

public class MyBean implements java.lang.Comparable {

	private String TV;
	private String TEXT;

	public MyBean(String tV, String tEXT) {
		TV = tV;
		TEXT = tEXT;
	}

	public String getTV() {
		return TV;
	}

	public void setTV(String tV) {
		TV = tV;
	}

	public String getTEXT() {
		return TEXT;
	}

	public void setTEXT(String tEXT) {
		TEXT = tEXT;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
