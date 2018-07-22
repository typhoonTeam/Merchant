package typhoon.merchant.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import typhoon.merchant.pojo.User;
import typhoon.merchant.service.impl.UserServiceImpl;
import typhoon.merchant.util.UUIDUtil;

/**
 * @author GAOJO2
 */
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserServiceImpl impl;
    public UpdatePasswordServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	impl = impl.getInstance();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------------------UpdatePasswordServlet------------------------------");
		HttpSession sen = request.getSession();
		User user =(User) sen.getAttribute("user");
		String shopId = user.getShopId();
		String userName = user.getUsername();
		String newPwd = null;
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems = null;
		boolean flag = false;
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem fileItem:fileItems) {
				if(fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("newPassword")) {
						newPwd = fileItem.getString();
					}
				    if(fileItem.getFieldName().equals("password")) {
				    	if(user.getPassword().equals(fileItem.getString())) {
				    		flag = true;
				    	}
				    }
				}else {
				}
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out=response.getWriter();
		if(flag == true) {
			impl.updatePassword(new User(shopId,userName,newPwd));
			out.print("{\"status\":\"OK\"}");
		}else {
			out.print("{\"status\":\"FAIL\"}");
		}
		
		out.close();
	}

}
