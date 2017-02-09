package com.wmc.pojo;

import java.io.Serializable;

/**
 * 订单与商品类
 * @author wmc
 * @since 2017.02.09
 */
public class OrderGoods implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderId;
	private String goodsId;
	
	public OrderGoods() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	
}
