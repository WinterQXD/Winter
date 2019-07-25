package com.vote.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.dao.UploadDao;

public class Upload2Action extends ActionSupport {
	private UploadDao updao;
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getQseq() {
		return qseq;
	}

	public void setQseq(int qseq) {
		this.qseq = qseq;
	}

	public int getSelseq() {
		return selseq;
	}

	public void setSelseq(int selseq) {
		this.selseq = selseq;
	}

	private int oid;
	private int qseq;
	private int selseq;

	private File fileUpload;

	private String fileName = "";// 文件名称

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String execute() {

		// 文件保存目录路径
		HttpServletRequest request = ServletActionContext.getRequest();
		String savePath = request.getSession().getServletContext()
				.getRealPath("/view/upload");
		String rootUrl = request.getContextPath() + "/view/upload";
		File file = new File(savePath);
		// 判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + "目录不存在，需要创建");
			// 创建目录
			file.mkdir();
		}
		// 消息提示
		String message = "";

		// 使用Apache文件上传组件处理文件上传步骤：
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		System.out.println(upload);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 3、判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 按照传统方式获取数据
			return null;
		} else {

			// Struts2 请求 包装过滤器
			MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
			// 获得上传的文件名
			String fileName = wrapper.getFileNames("fileUpload")[0];
			try {
				String sysFilePath = "/view/upload";
				String rootpath=request.getContextPath();
				// 获得项目的存在绝对路径
				String filepath = request.getSession().getServletContext()
						.getRealPath("/")
						+ sysFilePath + "/" + "";
				// 保存文件的相对路径
				String sqlfilepath =rootpath+ sysFilePath + "/" + "";
				// //获取后缀名
				int t3 = fileName.lastIndexOf(".");
				String fileExt = fileName.substring(t3 + 1, fileName.length());
				// 获取新文件名；
				String newDateStr = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()).toString();// 获取前17位
				String newRandom = "";// 获取后三位随机数
				int newInt = (int) (Math.random() * 1000);
				if (newInt < 100) {
					newRandom = "0" + String.valueOf(newInt);
				} else
					newRandom = String.valueOf(newInt);
				// 新的文件名字
				String newfilename = newDateStr + newRandom;
				String newName = newDateStr + newRandom + "." + fileExt;

				// 获取上传文件的大小
				InputStream in = new FileInputStream(fileUpload);
				int len = in.available();
				int max = 10485760;

				System.out.println(sqlfilepath+newName);
				if (len > 0 || len < max) {
					String size = String.valueOf(len);
					this.uploadStuPhoto(fileUpload, filepath, newName);

				}
				updao.savaorUpdate(oid, qseq, selseq, sqlfilepath+newName);
			} catch (Exception e) {
				// 输出错误日志详细信息
			}

		}
		return "success";

	}

	public boolean uploadStuPhoto(File dos, String dir, String newName) {


		try {
			InputStream in = null;
			OutputStream out = null;
			File dis = null;
			try {

				// 判断目录是否存在 不在的话，建
				File directory = new File(dir);
				if (!directory.exists() && !directory.isDirectory()) {
					directory.mkdirs();
				}

				dis = new File(directory + File.separator + newName);

				in = new BufferedInputStream(new FileInputStream(dos),
						16 * 1024);
				out = new BufferedOutputStream(new FileOutputStream(dis),
						16 * 1024);
				byte[] buffer = new byte[16 * 1024];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}

			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public UploadDao getUpdao() {
		return updao;
	}

	public void setUpdao(UploadDao updao) {
		this.updao = updao;
	}

}
