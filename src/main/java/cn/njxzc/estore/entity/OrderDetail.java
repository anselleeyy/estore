package cn.njxzc.estore.entity;

public class OrderDetail {
	
	public Integer id;
	
	public Long itemId;
	
	public String orderId;
	
	public Integer num;
	
	public String title;
	
	public Double price;
	
	public Double totalFee;
	
	public String picUrl;

	public OrderDetail() {
		super();
	}

	public OrderDetail(Integer id, Long itemId, String orderId, Integer num, String title, Double price,
			Double totalFee, String picUrl) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.orderId = orderId;
		this.num = num;
		this.title = title;
		this.price = price;
		this.totalFee = totalFee;
		this.picUrl = picUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", num=" + num + ", title="
				+ title + ", price=" + price + ", totalFee=" + totalFee + ", picUrl=" + picUrl + "]";
	}

}
