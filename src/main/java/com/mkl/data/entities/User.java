package com.mkl.data.entities;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User
{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "user_name", length = 25)
	private String userName;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "user_pass")
	private String userPass;

	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
			@JoinColumn(name = "role_name", referencedColumnName = "role_name")})
	@ManyToMany
	private List<Role> roleList = new ArrayList();

	public List<String> getRolesAsStrings() {
		if (roleList.isEmpty()) {
			return null;
		}
		List<String> rolesAsStrings = new ArrayList();
		for (Role role : roleList) {
			rolesAsStrings.add(role.getRoleName());
		}
		return rolesAsStrings;
	}

	public User() {}

	public boolean verifyPassword(String pw){
		return pw.equals(userPass);
		//return BCrypt.checkpw(pw, userPass);
	}

	public void hashPassword() {
		this.userPass = BCrypt.hashpw(this.userPass, BCrypt.gensalt());
	}

	public User(String userName, String userPass) {
		this.userName = userName;
		this.userPass = userPass;
		//hashPassword();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void addRole(Role userRole) {
		roleList.add(userRole);
	}
}
