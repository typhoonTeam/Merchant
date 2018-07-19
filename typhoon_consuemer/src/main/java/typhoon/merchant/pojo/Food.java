package typhoon.merchant.pojo;

public class Food {
	private int id;
	private String foodName;
	private Double price;
	private String picture;
	private String info;
	private String status;
	private String shopId;

	public Food() {
		super();
	}

	public Food(String foodName, Double price, String picture, String info, String status, String shopId) {
		super();

		this.foodName = foodName;
		this.price = price;
		this.picture = picture;
		this.info = info;
		this.status = status;
		this.shopId = shopId;
	}

	public Food(int id, String foodName, Double price, String picture, String info, String status, String shopId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.picture = picture;
		this.info = info;
		this.status = status;
		this.shopId = shopId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", price=" + price + ", picture=" + picture + ", info="
				+ info + ", status=" + status + ", shopId=" + shopId + "]";
	}

}