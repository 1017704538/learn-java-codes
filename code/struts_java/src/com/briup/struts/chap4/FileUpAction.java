package com.briup.struts.chap4;

import java.awt.Checkbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileUpAction extends ActionSupport implements RequestAware{
	private File file;
	private String fileFileName;
	private Map<String, Object> request;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		//ServletActionContext.getServletContext() ��ȡ����·��
		String root = ServletActionContext.getServletContext().getRealPath("/file");
		System.out.println(root);
		File f = new File(root);
		if(!f.exists()){//����Ŀ¼
			f.mkdir();
		}
		//�ж��Ƿ���ͼƬ
		/*boolean flag = Check.isPicture(fileFileName,"");
		if(true){
			request.put("msg", "ֻ���ϴ�ͼƬ");
			return ERROR;
		}*/
		//f2�ϴ��ļ���ŵ�λ��
		File f2 = new File(f, fileFileName);
		//����������ȡ�����ļ�������
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[1024];
		int num = 0;
		//�����������ȡ��������д�뵽�Ĺ�����f2�ļ���
		OutputStream os = new FileOutputStream(f2);
		while((num = is.read(b)) != -1){
			os.write(b);
		}
		os.flush();
		request.put("path", file);
		os.close();
		return SUCCESS;
	}
}
