package com.gooner.dhaka.bhogatedotcom.gottofindout;

import lombok.extern.slf4j.Slf4j;

public class SimpleJavaPojo {

	private int id;
	private String name;
	
	public SimpleJavaPojo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SimpleJavaPojo [id=" + id + ", name=" + name + "]";
	}
	
	

}
