package com.wmc.pojo;

import java.io.Serializable;
/**
 * 商品图片类
 * @author wmc
 * @since 2017.02.09
 */
public class GoodsImage implements Serializable{

	private static final long serialVersionUID = 1L;

	private String goodsImageId;
	private String goodsId;		//Goods的ID
	private String photoId;		//图片在MongoDb保存的ID
	private String createTime;	//创建时间
	private String photoType;	//图片类型（PT01：商品图片）
	
	public GoodsImage() {
		super();
	}
	
	public String getGoodsImageId() {
		return goodsImageId;
	}
	public void setGoodsImageId(String goodsImageId) {
		this.goodsImageId = goodsImageId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	
	
	
}
