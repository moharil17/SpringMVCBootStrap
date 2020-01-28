package com.spring.entities;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
@Table(name = "user_info")
public class Users {

	@Id
	@GeneratedValue
	private int userId;

	@Column(name = "user_password")

	@NotBlank
	private String userPassword;

	@Column(name = "user_name")
	@NotBlank
	private String userName;

	@Column(name = "email", unique = true)
	@NotBlank
	@Email
	private String userEmail;

	@OneToMany(targetEntity = Book.class, mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Book> book;

	@OneToMany(targetEntity = UserRoles.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRoles> role;
	@Lob
	private byte[] file;

	public Set<UserRoles> getRole() {
		return role;
	}

	public void setRole(Set<UserRoles> role) {
		this.role = role;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", userEmail="
				+ userEmail + ", book=" + book + ", file=" + Arrays.toString(file) + "]";
	}

}
