package typhoon.merchant.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import typhoon.merchant.dao.FoodDao;
import typhoon.merchant.dao.impl.FoodDaoImpl;
import typhoon.merchant.dao.impl.RegisterInfoDaoImpl;
import typhoon.merchant.pojo.Food;
import typhoon.merchant.service.FoodService;
import typhoon.merchant.util.ImgUtil;
import typhoon.merchant.util.UUIDUtil;

public class FoodServiceImpl implements FoodService {
	FoodDao foodDao;
	ImgUtil imgUtil;
	private static FoodServiceImpl instance;

	private FoodServiceImpl() {
		initData();
	}

	public static FoodServiceImpl getInstance() {
		if (instance == null) {
			synchronized (FoodServiceImpl.class) {
				if (instance == null) {
					instance = new FoodServiceImpl();
				}
			}
		}
		return instance;
	}

	public void initData() {
		foodDao = new FoodDaoImpl();
		imgUtil = new ImgUtil();
	}

	public List<Food> findFoodByShopId(String shopId) {
		return foodDao.findFoodByShopId(shopId);
	}

	public void DeleteFood(int id) {
		foodDao.delete(id);
	}

	public Food FindFoodById(int id) {
		Food food = foodDao.findFoodById(id);
		return food;
	}
@Override
public void updateFood(Food food) {
	foodDao.updateFood(food);
}
	public void UpdateFood(HttpServletRequest request, String realPath, String shopId) {
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		Food food = null;
		String foodName = null;
		Double price = null;
		String info = null;
		String status = null;
		String picture = null;
		String fileName = "default.img";
		int id = 0;
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {

					if (fileItem.getFieldName().equals("foodName")) {
						foodName = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("price")) {
						price = Double.valueOf(fileItem.getString());
					} else if (fileItem.getFieldName().equals("info")) {
						info = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("status")) {
						status = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("id")) {
						id = Integer.parseInt(fileItem.getString());
					}
					System.out.println(fileItem.getFieldName() + "\t" + fileItem.getString());
				} else {
					InputStream in = fileItem.getInputStream();
					// picture = imgUtil.img2String(in);
					byte[] buf = fileItem.get();
					fileName = fileItem.getName();
					OutputStream out = new FileOutputStream(realPath + "/" + fileName);
					picture = "img/" + fileItem.getName();
					// picture =
					// "http://10.222.29.191:9090/typhoon_merchant/img/"+fileItem.getName();
					out.write(buf);
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		food = new Food(id, foodName, price, picture, info, status, shopId);
		System.out.println(food.toString());
		foodDao.updateFood(food);

	}

	public Food AddFood(HttpServletRequest request, String path, String shopId) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		Food food = null;
		String foodName = null;
		Double price = null;
		String info = null;
		String status = null;
		String picture = null;
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {

					if (fileItem.getFieldName().equals("foodName")) {
						foodName = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("price")) {
						price = Double.valueOf(fileItem.getString());
					} else if (fileItem.getFieldName().equals("info")) {
						info = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					} else if (fileItem.getFieldName().equals("status")) {
						status = new String(fileItem.getString().getBytes("iso8859-1"), "UTF-8");
					}
					System.out.println(fileItem.getFieldName() + "\t" + fileItem.getString());
				} else {
					InputStream in = fileItem.getInputStream();
					// picture = imgUtil.img2String(in);
					byte[] buf = fileItem.get();
					String fileName = UUIDUtil.uuid32()+fileItem.getName();
					OutputStream out = new FileOutputStream(path + "/" + fileName);
					picture = "img/" + fileName;
					out.write(buf);
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		food = new Food(foodName, price, picture, info, status, shopId);
		System.out.println(food.toString());
		foodDao.addFood(food);
		return food;
	}

	@Override
	public void addFood(Food food) {
		foodDao.addFood(food);
		
	}
}
