package cn.njxzc.estore.entity;

import java.util.Date;
import java.util.List;

public class Order {
	
	public String orderId;
	
	public Double payment;
	
	public Long userId;
	
	public Integer addressId;
	
	public Double postFee;
	
	public Integer status;
	
	public Date createTime;
	
	public Date updateTime;
	
	public Date paymentTime;
	
	public Date consignTime;
	
	public Date endTime;
	
	public Date closeTime;
	
	public List<OrderDetail> details;

	public Order() {
		super();
	}

	public Order(String orderId, Double payment, Long userId, Integer addressId, Double postFee, Integer status,
			Date createTime, Date updateTime, Date paymentTime, Date consignTime, Date endTime, Date closeTime,
			List<OrderDetail> details) {
		super();
		this.orderId = orderId;
		this.payment = payment;
		this.userId = userId;
		this.addressId = addressId;
		this.postFee = postFee;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.paymentTime = paymentTime;
		this.consignTime = consignTime;
		this.endTime = endTime;
		this.closeTime = closeTime;
		this.details = details;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Double getPostFee() {
		return postFee;
	}

	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getConsignTime() {
		return consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", payment=" + payment + ", userId=" + userId + ", addressId=" + addressId
				+ ", postFee=" + postFee + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", paymentTime=" + paymentTime + ", consignTime=" + consignTime + ", endTime=" + endTime
				+ ", closeTime=" + closeTime + "]";
	}

}
