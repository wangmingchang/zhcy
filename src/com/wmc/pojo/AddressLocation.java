package com.wmc.pojo;

import java.io.Serializable;

/**
 * 地址位置类（全国各地的省市镇）
 * @author wmc
 * @since 2017.02.09
 */
public class AddressLocation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String locationId;	//位置ID
	private String upLocationId;	//上一级位置ID
	private String locationCode;	//位置编号
	private String locationName;	//位置名称
	private String locationDesc;	//位置简称
	private String locationType;	//位置类型
	private String locationLevel;	//位置级别
	
	public AddressLocation() {
		super();
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getUpLocationId() {
		return upLocationId;
	}

	public void setUpLocationId(String upLocationId) {
		this.upLocationId = upLocationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationLevel() {
		return locationLevel;
	}

	public void setLocationLevel(String locationLevel) {
		this.locationLevel = locationLevel;
	}
	
	
}
