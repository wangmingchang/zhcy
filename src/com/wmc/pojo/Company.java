package com.wmc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司类
 * 
 * @author wmc
 * @since 2017.02.09
 */
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	private String companyId;
	private String companyName; // 公司名称
	private String addressId; // Address的ID
	private String fixPhone; // 公司固话
	private Date createTime; // 创建时间
	private Date updateTime;

	public Company() {
		super();
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getFixPhone() {
		return fixPhone;
	}

	public void setFixPhone(String fixPhone) {
		this.fixPhone = fixPhone;
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
