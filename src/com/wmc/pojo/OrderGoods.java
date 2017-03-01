package com.wmc.pojo;

import java.io.Serializable;

/**
 * 订单与商品类
 * 
 * @author wmc
 * @since 2017.02.09
 */
public class OrderGoods implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderCode;
	private String goodsId;

	public OrderGoods() {
		super();
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

}
