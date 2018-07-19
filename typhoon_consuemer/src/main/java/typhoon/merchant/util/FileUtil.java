package typhoon.merchant.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class FileUtil {
	public void FileStore(HttpServletRequest request, String path) throws IOException, FileNotFoundException {
		
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		List<FileItem> fileItems;
		try {
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "\t" + fileItem.getString());
				} else {
					InputStream in = fileItem.getInputStream();
					byte[] buf = fileItem.get();
					String fileName = fileItem.getName();
					OutputStream out = new FileOutputStream(path + "/" + fileName);
					out.write(buf);
					out.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}