package com.wmc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * 
 * @author wmc
 * @since 2017.02.09
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String systemUserId;// 系统用户ID
	private String realName; // 真实姓名
	private String type; // 用户类型（U01：个人；U02：企业）
	private String companyId; // 公司ID
	private String addressId; // 地址ID
	private String photoId; // 图片ID（保存在Mongodb中）
	private Date createTime;
	private Date updateTime;

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(String systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	

}
