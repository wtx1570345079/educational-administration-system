package com.bear.pojo;

public class Teacher {
	 private int id;
	  // ����Ψһ
	  private String number;
	  // ����
	  private String name;
	  private String sex;
	  private String phone;
	  // ��ʦ���̿γ�
	  private Course course;
	  
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
