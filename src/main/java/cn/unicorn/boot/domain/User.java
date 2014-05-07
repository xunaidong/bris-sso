package cn.unicorn.boot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable {

	public User() {

	}

	public User(String userNo, String username, String email, String password,
			String mobile) {
		this.userNo = userNo;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")     
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")  
	private String userNo;
	@Column(nullable = false)
	private String username;
	@Column
	private String email;
	@Column(nullable = false)
	private String password;
	@Column
	private String mobile;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", username=" + username + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userNo == null) {
			if (other.userNo != null)
				return false;
		} else if (!userNo.equals(other.userNo))
			return false;
		return true;
	}
}
