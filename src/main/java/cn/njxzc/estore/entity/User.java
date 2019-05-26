package cn.njxzc.estore.entity;

import java.io.Serializable;
import java.util.Date;

import cn.njxzc.estore.utils.Constants;

/**
 * 用户信息表
 * 
 * @author Ansel
 *
 */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1678264094225963574L;

	// 用户id
	private Long id;
	
	// 用户名
	private String username;
	
	// 密码
	private String password;
	
	// 手机号
	private String phone;
	
	// 邮箱
	private String email;
	
	// 性别
	private int sex;
	
	// 地址
	private String address;
	
	// 用户状态
	private int state;
	
	// 用户描述
	private String description;
	
	// 用户角色
	private int roleId;
	
	// 用户头像地址
	private String avatar;
	
	// 创建时间
	private Date created;
	
	// 信息更新时间
	private Date updated;

	public User() {
		super();
	}

	public User(Long id, String username, String password, String phone, String email, int sex, String address,
			int state, String description, int roleId, String avatar, Date created, Date updated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.sex = sex;
		this.address = address;
		this.state = state;
		this.description = description;
		this.roleId = roleId;
		this.avatar = avatar;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAvatar() {
		return avatar.startsWith("http") ? avatar : Constants.NGINX_URL + avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", sex=" + sex + ", address=" + address + ", state=" + state + ", description=" + description
				+ ", roleId=" + roleId + ", avatar=" + avatar + ", created=" + created + ", updated=" + updated + "]";
	}

}
