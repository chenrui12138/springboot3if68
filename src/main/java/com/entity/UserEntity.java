package com.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * 管理员表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	* @Description: 主键id
	* @Author: 陈锐  2022/04/02 10:26
	*/
	@TableId(type = IdType.INPUT)
	private Long id;
	
	/**
	 * 用户姓名
	 */
	private String xingming;
	
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 工号
	 */
	private String gonghao;
	
	/**
	 * 用户类型
	 */
	private String role;
	
	private Date addtime;

	/**
	 * 性别
	 */
	private String xingbie;

	/**
	 * 联系电话
	 */
	private String lianxidianhua;

	/**
	 * 删除标志 1未删除，0已删除
	 */
	@TableLogic(value = "1", delval = "0")
	private String isDelete;

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public Date getAddtime() {
//		return addtime;
//	}
//
//	public void setAddtime(Date addtime) {
//		this.addtime = addtime;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

}
