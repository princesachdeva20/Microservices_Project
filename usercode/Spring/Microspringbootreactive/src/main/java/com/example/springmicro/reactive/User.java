package com.example.springmicro.reactive;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;


public class User {

	//write your code here
    private String id, name, password;
	List<String> roles;

	User(){
	}

	public User (String name, String password, List<String> roles){
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
	}
	public User (String id, String name, String password, List<String> roles){
		this.id = id;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	String getId(){
		return id;
	}
	void setId(String id){
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public List<String> getRoles(){
		return roles;
	}
	public void setId(List<String> roles ){
		this.roles = roles;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
			Objects.equals(name, user.name) &&
			Objects.equals(password, user.password) &&
			Objects.equals(roles, user.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, password, roles);
	}

	@Override
	public String toString() {
		return "User{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", password='" + "*******" + '\'' +
			", roles=" + roles +
			'}';
	}
}
