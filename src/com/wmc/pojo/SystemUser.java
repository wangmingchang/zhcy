package com.wmc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户类
 * 
 * @author wmc
 * @since 2017.02.09
 */
public class SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String systemUserId;
	private String userName; // 用户名
	private String userMobilePhone; // 手机号
	private String password; // 密码
	private String status; // 状态（S01：正常；S02：停用；S03：初始化）
	private Date createTime; // 创建时间
	private Date updateTime; // 修改时间

	public SystemUser() {
		super();
	}

	public String getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(String systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobilePhone() {
		return userMobilePhone;
	}

	public void setUserMobilePhone(String userMobilePhone) {
		this.userMobilePhone = userMobilePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
