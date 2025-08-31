package com.educandoweb.course.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String username;
	private String password;

	public User() {
	}
	public User(Long id, String name,  String username,
	            String email,String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(getId(), user.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}
}