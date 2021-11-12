package com.dao.config.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.dao.config.IResultSetHandler;

/**
 * <p>
 * Title: BeanHandler
 * </p>
 * <p>
 * Description: ����һ��JavaBean
 * </p>
 * 
 * @author wangxuanye
 * @date 2020��2��4��
 */
public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> clazz;

	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T handle(ResultSet rs) throws Exception {
		// �����Ĭ��ָ��Ϊ��һ�����ݵ�ǰһ��
		if (rs.next()) {
			// ���ݴ�����ֽ��봴�������ָ������
			T obj = clazz.newInstance();
			// ��ȡָ���ֽ�����Ϣ
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			// ��ȡ��������������
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				// ��ȡ������ж�Ӧ�ֶ�����ֵ
				Object o = rs.getObject(pd.getName());
				// ִ�е�ǰ�������������
				pd.getWriteMethod().invoke(obj, o);
			}
			return obj;
		}
		return null;
	}
}
