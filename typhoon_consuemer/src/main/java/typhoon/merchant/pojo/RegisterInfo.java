package typhoon.merchant.pojo;

import java.io.Serializable;
import java.util.UUID;

public class RegisterInfo implements Serializable {// 注册信息。。本地无法修改
	String shopId;// id
	String creditCode;// 工商号
	String idCard;// 身份证
	String corporateName;//法人名字
	String picture;// 身份证图片base64 TODO
	String phone;// 电话
	String shopName;// 店名
	String address;// 地址
	String comments;// 备注
	// String status;
	
	public RegisterInfo(String creditCode, String idCard, String corporateName, String picture, String phone,
			String shopName, String address, String comments) {
		super();
		this.shopId = UUID.randomUUID().toString().replace("-", "");
		this.creditCode = creditCode;
		this.idCard = idCard;
		this.corporateName = corporateName;
		this.picture = picture;
		this.phone = phone;
		this.shopName = shopName;
		this.address = address;
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "RegisterInfo [shopId=" + shopId + ", creditCode=" + creditCode + ", idCard=" + idCard
				+ ", corporateName=" + corporateName + ", picture=" + picture + ", phone=" + phone + ", shopName="
				+ shopName + ", address=" + address + ", comments=" + comments + "]";
	}
	public RegisterInfo(String shopId, String creditCode, String idCard, String corporateName, String picture,
			String phone, String shopName, String address, String comments) {
		super();
		this.shopId = shopId;
		this.creditCode = creditCode;
		this.idCard = idCard;
		this.corporateName = corporateName;
		this.picture = picture;
		this.phone = phone;
		this.shopName = shopName;
		this.address = address;
		this.comments = comments;
	}

	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	

}
