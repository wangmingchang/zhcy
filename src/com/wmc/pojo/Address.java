package com.wmc.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 地址类
 * @author wmc
 * @since 2017.02.09
 */
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String addressId;	//主键
	private String locationId;	//AddressLocation的ID
	private String addressDetail;	//地址详情
	private Date createTime;	//创建时间
	private String type;	//地址类型
	
	public Address() {
		super();
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
