package action;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{
	private File upload;
	private String uploadFileName;//表单元素的名字+FileName
	private String directory;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String upload() throws Exception {
		System.out.println("+++++++++++++++++++++");
	
		UUID uuid1 = UUID.randomUUID();
		String uuid = uuid1.toString();
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getRealPath(directory);
		FileUtils.copyFile(upload, new File(path+"/"+uuid+uploadFileName));
		System.out.println("----------------");
		return "ok";
	}

}
