package typhoon.merchant.pojo;

import java.sql.Date;
/**
 * 
 * @author GAOJO2
 *
 */
public class Advertisement {
	private Integer id;
	private String shop_id;
	private String picture;
	private String slogan;
	private int state;
	private Date time;
	
	public Advertisement() {
		super();
	}
	public Advertisement(String shop_id, String picture, String slogan, int state, Date time) {
		super();
		this.shop_id = shop_id;
		this.picture = picture;
		this.slogan = slogan;
		this.state = state;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	
	public String getShop_id() {
		return shop_id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
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
		return "Advertisement [id=" + id + ", shop_id=" + shop_id + ", picture=" + picture + ", slogan=" + slogan
				+ ", state=" + state + ", time=" + time + "]";
	}
	
	
}
