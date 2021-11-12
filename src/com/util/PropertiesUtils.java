package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * <p>
 * Title: PropertiesUtils
 * </p>
 * <p>
 * Description: 配置文件工具类
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年2月12日
 */
public class PropertiesUtils {
	private String filePath;

	public PropertiesUtils(String filePath) {
		super();
		this.filePath = filePath;
	}

	/**
	 * 获取key对应的值
	 * 
	 * @param key
	 * @return
	 */
	public Object getProperty(String key) {
		Properties pro = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pro.get(key);
	}

	/**
	 * 更新键值对，有就更新，没有就新增
	 * 
	 * @param key
	 * @param value
	 */
	public void setProperty(String key, Object value) {
		// 1.读取原来的数据
		Properties pro = new Properties();
		FileInputStream in = null;
		try {
			File f = new File(filePath);
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 2.更新数据
		pro.setProperty(key, (String) value);
		try {
			pro.store(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void clearInfoForFile(String fileName) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String filePath = PropertiesUtils.class.getResource("").getPath() + "\\a.properties";
		PropertiesUtils property = new PropertiesUtils(filePath);
		// 读取属性
		property.setProperty("age", "20");
		property.clearInfoForFile(filePath);
		System.out.println(property.getProperty("age"));
		System.out.println(property.getProperty("name"));
	}

}
