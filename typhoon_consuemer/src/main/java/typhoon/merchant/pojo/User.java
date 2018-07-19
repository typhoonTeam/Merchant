package typhoon.merchant.pojo;

import java.util.UUID;

public class User {
	private String shopId;//id
	private String username;//用户名
	private String password;//密码

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		shopId = UUID.randomUUID().toString().replace("-", "");
		
		this.username = username;
		this.password = password;
	}
	public User(String shopId,String username, String password) {
		super();
		this.shopId = shopId;
		this.username = username;
		this.password = password;
	}
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
