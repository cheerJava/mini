package com.cheer.mini.ums.model;

import java.util.List;

import org.apache.log4j.Logger;

import java.math.BigDecimal;

import com.cheer.mini.base.model.BaseEntity;

public class Order extends BaseEntity {
	
	private transient Logger logger = Logger.getLogger(getClass());
	
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
	
	public Order(){
		logger.info("new Ordrer ()");
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		logger.info("new ordrer.setSelected ("+selected+")");
		this.selected = selected;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		logger.info("new ordrer.setId ()");
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
		logger.info("new ordrer.setStatus ()");
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
