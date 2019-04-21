package cn.njxzc.estore.entity;

import java.io.Serializable;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045819799412046378L;

	private int id;

	private Long userId;

	private Long itemId;

	private int number;
	
	private int status;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, Long userId, Long itemId, int number, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.number = number;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", itemId=" + itemId + ", number=" + number + ", status="
				+ status + "]";
	}

}
