package com.dzbs.bean.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;


/**
 * 用户*/
@Entity  
@Table(name = "t_member")
public class Member {
	
	/**用户认证信息**/
	//用户ID	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Expose 
	private int id;
	
	//注册用户
    private	String username;
    
	//注册密码
	private	String password;
	
	//用户状态
	private	boolean enabled;
	
	/**用户基本信息**/
	//用户真实姓名
	 @Expose 
	private String realname;

	//邮箱
	 @Expose 
	private String email;
	
	//性别（男0,女1）
	 @Expose 
	private boolean gender;
	
	//头像
	 @Expose 
	private String imgurl;
	
	//手机号码
	 @Expose 
    private String mobile;
	   
	/**乘客信息**/
    //乘客会员等级（0:基础会员,1:普通会员,2:高级会员）
	 @Expose 
    private int level;

	/**巴士司机信息**/
    //巴士司机审核状态（0:未审核（未通过）,1:通过）
	 @Expose 
    private boolean license;
    
	//角色列表
	@ManyToMany(targetEntity = Role.class,fetch = FetchType.EAGER)  
    @JoinTable(name="member_role" , joinColumns = {  
            @JoinColumn(name = "member_id",referencedColumnName="id")  
    }, inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName="id")})
	private Set<Role> roles = new HashSet<Role>();
	
	//创建时间
	@Temporal(TemporalType.DATE)  
	private Date create_date; 
	//更新时间
	@Temporal(TemporalType.DATE)  
	private Date update_date ; 	
	
	
	/*******************SET GET METHOD***********************************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getLicense() {
		return license;
	}

	public void setLicense(boolean license) {
		this.license = license;
	}
}

