/**  
* <p>Title: BeanListHandler.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020��2��4��  
* @version 1.0  
*/
package com.dao.config.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.config.IResultSetHandler;

/**
 * <p>
 * Title: BeanListHandler
 * </p>
 * <p>
 * Description: ����һ��JavaBean�ļ���
 * </p>
 * 
 * @author wangxuanye
 * @date 2020��2��4��
 */
public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
	private Class<T> clazz;

	public BeanListHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		// ��ȡָ���ֽ�����Ϣ
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
		// ��ȡ��������������
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		List<T> list = new ArrayList<>();
		while (rs.next()) {
			T obj = clazz.newInstance();
			for (PropertyDescriptor pd : pds) {
				// ��ȡ������ж�Ӧ�ֶ�����ֵ
				Object o = rs.getObject(pd.getName());
				// ִ�е�ǰ�������������
				pd.getWriteMethod().invoke(obj, o);
			}
			list.add(obj);
		}
		return list;
	}
}
