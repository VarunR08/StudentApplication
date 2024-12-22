package com.Student.DTO;
//POJO CLASS 
public class Student {
private int id;
private String name;
private long phone;
private String mail_id;
private String branch;
private String location;
private String pass;
private String date;

//getters and setters
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
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getMailId() {
	return mail_id;
}
public void setMailId(String mailId) {
	this.mail_id = mailId;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
// to string method
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", mail_id=" + mail_id + ", branch=" + branch
			+ ", location=" + location + "]";
}



}
