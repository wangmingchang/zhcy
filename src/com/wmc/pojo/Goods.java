package com.wmc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类
 * @author wmc
 * @since 2017.02.09
 */
public class Goods implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String goodsId;
	private String goodsCode;	//商品编号
	private String goodsName;	//商品名称
	private String goodsType;	//商品类型
	private String presentation;	//商品介绍
	private String goodsStatus;		//商品状态
	private String goodsImageId;	//商品图片ID
	private Double price;			//价格（单价）
	private Date createTime;
	private Date updateTime;
	
	public Goods() {
		super();
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public String getGoodsImageId() {
		return goodsImageId;
	}

	public void setGoodsImageId(String goodsImageId) {
		this.goodsImageId = goodsImageId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
