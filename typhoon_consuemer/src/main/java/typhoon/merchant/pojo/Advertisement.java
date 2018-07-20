package typhoon.merchant.pojo;

import java.sql.Date;
/**
 * 
 * @author GAOJO2
 *
 */
public class Advertisement {
	private Integer id = 0;
	private String shopId;
	private String picture;
	private String slogan;
	private Double price;
	private int state;
	private Date time;
	
	public Advertisement() {
		super();
	}
	
	public Advertisement(String shopId, String picture, String slogan, Double price, int state, Date time) {
		super();
		this.shopId = shopId;
		this.picture = picture;
		this.slogan = slogan;
		this.price = price;
		this.state = state;
		this.time = time;
	}

	public int getId() {
		return id;
	}
	
	public String getShopId() {
		return shopId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", shopId=" + shopId + ", picture=" + picture + ", slogan=" + slogan
				+ ", price=" + price + ", state=" + state + ", time=" + time + "]";
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
