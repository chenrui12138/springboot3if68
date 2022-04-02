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
 * 用户
 * 数据库通用操作实体类
 * @author 
 * @email 
 * @date 2021-11-30 14:36:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


//	public YonghuEntity() {
//
//	}
//
//	public YonghuEntity(T t) {
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
	 * 工号
	 */
	private String gonghao;
	
	/**
	 * 姓名
	 */
	private String xingming;
	
	/**
	 * 密码
	 */
	private String mima;
	
	/**
	 * 性别
	 */
	private String xingbie;
	
	/**
	 * 联系电话
	 */
	private String lianxidianhua;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	/**
	 * 删除标志 1未删除，0已删除
	 */
	@TableLogic(value = "1", delval = "0")
	private String isDelete;

	/**
	 * 用户类型
	 */
	private String role;

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
//	 * 设置：工号
//	 */
//	public void setGonghao(String gonghao) {
//		this.gonghao = gonghao;
//	}
//	/**
//	 * 获取：工号
//	 */
//	public String getGonghao() {
//		return gonghao;
//	}
//	/**
//	 * 设置：姓名
//	 */
//	public void setXingming(String xingming) {
//		this.xingming = xingming;
//	}
//	/**
//	 * 获取：姓名
//	 */
//	public String getXingming() {
//		return xingming;
//	}
//	/**
//	 * 设置：密码
//	 */
//	public void setMima(String mima) {
//		this.mima = mima;
//	}
//	/**
//	 * 获取：密码
//	 */
//	public String getMima() {
//		return mima;
//	}
//	/**
//	 * 设置：性别
//	 */
//	public void setXingbie(String xingbie) {
//		this.xingbie = xingbie;
//	}
//	/**
//	 * 获取：性别
//	 */
//	public String getXingbie() {
//		return xingbie;
//	}
//	/**
//	 * 设置：联系电话
//	 */
//	public void setLianxidianhua(String lianxidianhua) {
//		this.lianxidianhua = lianxidianhua;
//	}
//	/**
//	 * 获取：联系电话
//	 */
//	public String getLianxidianhua() {
//		return lianxidianhua;
//	}

}
