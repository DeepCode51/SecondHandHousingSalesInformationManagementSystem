package Pojo;

import java.util.List;

public class Userlist {
private Integer id;
private String name;
private String idcard;
private String phone;
private Integer user_id;
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}

}
