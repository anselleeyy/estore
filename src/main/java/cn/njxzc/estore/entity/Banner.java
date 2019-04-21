package cn.njxzc.estore.entity;

import java.util.Date;

import cn.njxzc.estore.utils.Constants;

public class Banner {
	
	// ID
	private int id;
	
	// 图片地址
	private String imgUrl;
	
	// 排序序号
	private int sortOrder;
	
	// 创建时间
	private Date created;
	
	// 更新时间
	private Date updated;

	public Banner() {
		super();
	}

	public Banner(int id, String imgUrl, int sortOrder, Date created, Date updated) {
		super();
		this.id = id;
		this.imgUrl = imgUrl;
		this.sortOrder = sortOrder;
		this.created = created;
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgUrl() {
		return Constants.NGINX_URL + imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", imgUrl=" + imgUrl + ", sortOrder=" + sortOrder + ", created=" + created
				+ ", updated=" + updated + "]";
	}

}
