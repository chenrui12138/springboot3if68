package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 收藏表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-11-30 14:36:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("storeup")
public class StoreupEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


//	public StoreupEntity() {
//
//	}
//
//	public StoreupEntity(T t) {
//		try {
//			BeanUtils.copyProperties(this, t);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.INPUT)
	private Long id;
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	/**
	 * 收藏id
	 */
					
	private Long refid;
	
	/**
	 * 表名
	 */
					
	private String tablename;
	
	/**
	 * 收藏名称
	 */
					
	private String name;
	
	/**
	 * 收藏图片
	 */
					
	private String picture;
	
	/**
	 * 类型(1:收藏,21:赞,22:踩)
	 */
					
	private String type;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	/**
	 * 删除标志 1未删除，0已删除
	 */
	@TableLogic(value = "1", delval = "0")
	private String isDelete;
//
//	public Date getAddtime() {
//		return addtime;
//	}
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
//	/**
//	 * 设置：用户id
//	 */
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}
//	/**
//	 * 获取：用户id
//	 */
//	public Long getUserid() {
//		return userid;
//	}
//	/**
//	 * 设置：收藏id
//	 */
//	public void setRefid(Long refid) {
//		this.refid = refid;
//	}
//	/**
//	 * 获取：收藏id
//	 */
//	public Long getRefid() {
//		return refid;
//	}
//	/**
//	 * 设置：表名
//	 */
//	public void setTablename(String tablename) {
//		this.tablename = tablename;
//	}
//	/**
//	 * 获取：表名
//	 */
//	public String getTablename() {
//		return tablename;
//	}
//	/**
//	 * 设置：收藏名称
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//	/**
//	 * 获取：收藏名称
//	 */
//	public String getName() {
//		return name;
//	}
//	/**
//	 * 设置：收藏图片
//	 */
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
//	/**
//	 * 获取：收藏图片
//	 */
//	public String getPicture() {
//		return picture;
//	}
//	/**
//	 * 设置：类型(1:收藏,21:赞,22:踩)
//	 */
//	public void setType(String type) {
//		this.type = type;
//	}
//	/**
//	 * 获取：类型(1:收藏,21:赞,22:踩)
//	 */
//	public String getType() {
//		return type;
//	}

}
