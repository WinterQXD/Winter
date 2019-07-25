
package com.vote.util;


import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



public class BeansFactory {

	private static Log log = LogFactory.getLog(BeansFactory.class);

	private static ApplicationContext appContext;

	private static ServletContext context;

	private static BeanFactory factory = null;
	static {
		try {
			factory = new ClassPathXmlApplicationContext(new String[] {
					"config/applicationContext.xml"
					 });
			// factory = new FileSystemXmlApplicationContext(
			// APPLICATION_CONTEXT_FILENAME);

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Spring解析 ap文件出错", e);
		}
	}

	public static void setContext(ServletContext context) {
		BeansFactory.context = context;
	}

	private static ApplicationContext getApplicationContext() {
		if (appContext == null) {
			if (context != null){
				appContext=WebApplicationContextUtils.getWebApplicationContext(context); 
				//appContext = (ApplicationContext) context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			}
		}
		return appContext;

	}

	/**
	 * @param name
	 * @return
	 */
	public static Object get(String name) {
		Object o = null;
		try {
			// o = factory.getBean(name);
			try {
				o = getApplicationContext().getBean(name);
			} catch (Exception e) {
				o = factory.getBean(name);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Spring装载出错 Bean name is " + name, e);
		}
		return o;

	}
	
	/**
	 * 读取blob内容
	 * @param byte[] blob数组
	 * @throws UnsupportedEncodingException */
	public static String getContent(byte[] bts) throws UnsupportedEncodingException{
		String content = new String(bts,"UTF-8");
		return content;
	}
	
	public static void main(String[] args) {
	}
}
