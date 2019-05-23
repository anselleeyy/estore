package cn.njxzc.estore.entity;

import java.util.Date;

import cn.njxzc.estore.utils.Constants;

public class Item {

	private Long id;
	
	private String title;
	
	private String author;
	
	private double price;
	
	private String publisher;
	
	private String picUrl;
	
	private int status;
	
	private int hotRate;
	
	private Date created;
	
	private Date updated;
	
	private ItemDetail itemDetail;

	public Item() {
		super();
	}

	public Item(Long id, String title, String author, double price, String publisher, String picUrl, int status,
			int hotRate, Date created, Date updated) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.picUrl = picUrl;
		this.status = status;
		this.hotRate = hotRate;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPicUrl() {
		return picUrl.startsWith("http") ? picUrl : Constants.NGINX_URL + picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getHotRate() {
		return hotRate;
	}

	public void setHotRate(int hotRate) {
		this.hotRate = hotRate;
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

	public ItemDetail getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(ItemDetail itemDetail) {
		this.itemDetail = itemDetail;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", publisher="
				+ publisher + ", picUrl=" + picUrl + ", status=" + status + ", hotRate=" + hotRate + ", created="
				+ created + ", updated=" + updated + "]";
	}
}
