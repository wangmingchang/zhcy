package com.wmc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单类
 * @author wmc
 * @since 2017.02.09
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderId;
	private String clientId;		//客户（user表ID）
	private String merchandiserId;	//业务员（user表ID）
	private String addressId;		//Address的ID
	private Double totalAmount;		//总金额
	private Integer totalNumber;	//总件数
	private String orderType;		//订单类型（TO1：个人；T02：公司或个体商户）
	private Date orderTime;			//创建时间
	
	public Order() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getMerchandiserId() {
		return merchandiserId;
	}
	public void setMerchandiserId(String merchandiserId) {
		this.merchandiserId = merchandiserId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	
	
}
