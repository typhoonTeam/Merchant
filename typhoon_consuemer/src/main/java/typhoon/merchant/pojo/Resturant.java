package typhoon.merchant.pojo;

public class Resturant {//é¤�åŽ…ä¿¡æ�¯
	private String shop_id;//id
	private String openTime;//å¼€é—¨æ—¶é—´
	private String closeTime;//å…³é—­æ—¶é—´
	private Double delivery;//è¿�é€�èŒƒå›´
	private Double deli_fee;//è¿�è´¹
	private String picture;//å›¾ç‰‡
	private String slogan;//å¹¿å‘Šä»‹ç»�
	private Integer status;//æ˜¯å�¦å…³åº—äº†
	private String comments;//å¤‡æ³¨
	
	
	
	public Resturant() {
		super();
	}

	public Resturant(String shop_id, String openTime, String closeTime, Double delivery, Double deli_fee,
			String picture, String slogan, Integer status, String comments) {
		super();
		this.shop_id = shop_id;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.delivery = delivery;
		this.deli_fee = deli_fee;
		this.picture = picture;
		this.slogan = slogan;
		this.status = status;
		this.comments = comments;
	}
	
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
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
	public Double getDeli_fee() {
		return deli_fee;
	}
	public void setDeli_fee(Double deli_fee) {
		this.deli_fee = deli_fee;
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
		return "Resturant [shop_id=" + shop_id + ", openTime=" + openTime + ", closeTime=" + closeTime + ", delivery="
				+ delivery + ", deli_fee=" + deli_fee + ", picture=" + picture + ", slogan=" + slogan + ", status="
				+ status + ", comments=" + comments + "]";
	}
	
	
}
