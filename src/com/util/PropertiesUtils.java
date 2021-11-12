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
 * Description: �����ļ�������
 * </p>
 * 
 * @author wangxuanye
 * @date 2020��2��12��
 */
public class PropertiesUtils {
	private String filePath;

	public PropertiesUtils(String filePath) {
		super();
		this.filePath = filePath;
	}

	/**
	 * ��ȡkey��Ӧ��ֵ
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
	 * ���¼�ֵ�ԣ��о͸��£�û�о�����
	 * 
	 * @param key
	 * @param value
	 */
	public void setProperty(String key, Object value) {
		// 1.��ȡԭ��������
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
		// 2.��������
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
		// ��ȡ����
		property.setProperty("age", "20");
		property.clearInfoForFile(filePath);
		System.out.println(property.getProperty("age"));
		System.out.println(property.getProperty("name"));
	}

}
