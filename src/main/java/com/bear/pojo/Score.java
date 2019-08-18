package com.bear.pojo;

public class Score {
	private int id;
	private int studentid;
	private Student student;
	private String score;
	private Course course;
	private int courseid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", studentid=" + studentid + ", student=" + student + ", score=" + score
				+ ", course=" + course + ", courseid=" + courseid + "]";
	}
	
}
