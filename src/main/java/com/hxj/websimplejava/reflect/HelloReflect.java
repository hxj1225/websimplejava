package com.hxj.websimplejava.reflect;

import com.hxj.websimplejava.validator.annotation.Length;

public class HelloReflect {

	@Length
	private String name = "hxj";
	private String address;
	private String email;
	public int age = 1;
	public static int page_size = 10;
	private static final int page_index = 1;
	private String phone[];
	private String privateParam = "a";
	public String[] getPhone() {
		return phone;
	}
	public void setPhone(String[] phone) {
		this.phone = phone;
	}

	
	public void sayHello() {
		System.out.println(page_index + privateParam);
	}
	@Length
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
