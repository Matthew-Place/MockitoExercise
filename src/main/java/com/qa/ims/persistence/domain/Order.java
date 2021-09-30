package com.qa.ims.persistence.domain;



public class Order {
	
	private Long orderId;
	private Long custId;
	private Long itemId;
	private Integer qty;
	private Double totalCost;
	private String itemName;
	private String custName;

	public Order(Long orderId, Long itemId, Integer qty, Double totalCost, String custName, String itemName) {
		this.setOrderId(orderId);
		this.setItemId(itemId);
		this.setQty(qty);
		this.setTotalCost(totalCost);
		this.setCustName(custName);
		this.setItemName(itemName);
	}

	
	public Order(Long custId, Long itemId, Integer qty) {
		this.setCustomerId(custId);
		this.setItemId(itemId);
		this.setQty(qty);
	}
	
	public Order(Long orderId, Long custId, Long itemId, Integer qty) {
		this.setOrderId(orderId);
		this.setCustomerId(custId);
		this.setItemId(itemId);
		this.setQty(qty);
	}
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Long getCustomerId() {
		return custId;
	}

	public void setCustomerId(Long custId) {
		this.custId = custId;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getQty() {
		return qty;
	}
	
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Override
	public String toString() {
		return "id: " + orderId + " first name: " + custName + " item: " + itemName + " Quantity: " + qty + " Total Price: " + totalCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId()))
			return false;
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		if (getQty() == null) {
			if (other.getQty() != null)
				return false;
		} else if (!getQty().equals(other.getQty()))
			return false;
		if (getTotalCost() == null) {
			if (other.getTotalCost() != null)
				return false;
		} else if (!getTotalCost().equals(other.getTotalCost()))
			return false;
		if (getCustName() == null) {
			if (other.getCustName() != null)
				return false;
		} else if (!getCustName().equals(other.getCustName()))
			return false;
		return true;
	}



}
