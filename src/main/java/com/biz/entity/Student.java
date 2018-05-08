
package com.biz.entity;

import java.util.Date;

/**
 * 学生类实�?
 * */
public class Student {
	/*A:学生数据包含:
	Id 字符串类型长�? 40,
	姓名 (name)字符串类型长�? 40,
	出生日期(birthday) 日期类型,
	备注 (description)字符串类型长�? 255,
	平均�?(avgscore) 整数类型,*/	
	private String id;
	private String name;
	private String birthday;
	private String description;
	private int avgscore;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(int avgscore) {
		this.avgscore = avgscore;
	}
	
	
}
