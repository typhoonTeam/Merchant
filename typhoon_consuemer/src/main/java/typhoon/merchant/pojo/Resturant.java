package typhoon.merchant.pojo;
/**
 * 
 * @author GAOJO2
 *
 */
public class Resturant {
	private String shopId;
	private String openTime;
	private String closeTime;
	private Double delivery;
	private Double deliFee;
	private String picture;
	private String slogan;
	private Integer status;
	private String comments;
	
	
	
	public Resturant() {
		super();
	}

	public Resturant(String shop_id, String openTime, String closeTime, Double delivery, Double deli_fee,
			String picture, String slogan, Integer status, String comments) {
		super();
		this.shopId = shop_id;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.delivery = delivery;
		this.deliFee = deli_fee;
		this.picture = picture;
		this.slogan = slogan;
		this.status = status;
		this.comments = comments;
	}
	
	
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
	public Double getDelivery() {
		return delivery;
	}
	public void setDelivery(Double delivery) {
		this.delivery = delivery;
	}
	
	public Double getDeliFee() {
		return deliFee;
	}

	public void setDeliFee(Double deliFee) {
		this.deliFee = deliFee;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	
	public Integer getStatus() {
		return status;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Resturant [shop_id=" + shopId + ", openTime=" + openTime + ", closeTime=" + closeTime + ", delivery="
				+ delivery + ", deli_fee=" + deliFee + ", picture=" + picture + ", slogan=" + slogan + ", status="
				+ status + ", comments=" + comments + "]";
	}
	
	
}
