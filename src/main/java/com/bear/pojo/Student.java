package com.bear.pojo;

public class Student {
  private int id;
  // 属性唯一
  private String number;
  private String name;
  private String sex;
  private String phone;
  // 分数对象
  private Score score;
  
public Score getScore() {
	return score;
}
public void setScore(Score score) {
	this.score = score;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Student [id=" + id + ", number=" + number + ", name=" + name + ", sex=" + sex + ", phone=" + phone
			+ "]";
}
  
} 
