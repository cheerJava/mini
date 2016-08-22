package com.cheer.mini.ums.model;

import java.util.List;
import java.math.BigDecimal;

import com.cheer.mini.base.model.BaseEntity;

public class Order extends BaseEntity {
	
	public interface ORDER_STATUS {
		int DRAFT = 0;
		int COMMIT = 1;
		int PAYMENT = 2;
		int RECEIVE = 3;
		int CLOSE = 4;
	}
	
	private Boolean selected = Boolean.FALSE;
	
	private String id;
	
	private BigDecimal amount;
	
	private String title;
	
	private String remark;
	
	private int status = ORDER_STATUS.DRAFT;
	
	private List<OrderItem> items;
	
	

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [selected=" + selected + ", id=" + id + ", amount="
				+ amount + ", title=" + title + ", remark=" + remark
				+ ", status=" + status + ", items=" + items + "]";
	}

}
