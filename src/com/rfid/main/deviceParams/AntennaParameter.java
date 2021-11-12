package com.rfid.main.deviceParams;

import javax.swing.JComboBox;

/**
 * ���߲�������
 * 
 * @author zhuQixiang
 * 
 */
public class AntennaParameter {

	/**
	 * �����źŶ�ȡ���ٶ�ѡ���б�
	 * 
	 * @param combo ������ؼ�
	 * @return �����б�
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxSecond(JComboBox combobox) {
		for (int i = 360; i >= 0; i = i - 10) {
			combobox.addItem(i);
		}
		return combobox;
	}

	/**
	 * �����źŶ�ȡ��ѡ���б�DBM����
	 * 
	 * @param combo ������ؼ�
	 * @return �����б�
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxDbm(JComboBox combobox) {
		for (int i = 33; i >= 0; i = i - 1) {
			combobox.addItem(i);
		}
		combobox.setSelectedItem(30);
		return combobox;
	}

	/**
	 * <p>
	 * Title: comboboxPort
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void comboboxPort(JComboBox combobox, JComboBox combobox2, double low, double high) {
		combobox.removeAllItems();
		combobox2.removeAllItems();
		for (double i = low; i <= high; i = i + 0.5) {
			combobox.addItem(i);
		}
		for (double i = high; i >= low; i = i - 0.5) {
			combobox2.addItem(i);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxRecieve(JComboBox combobox) {
		combobox.addItem("���շ�ʽ");
		combobox.addItem("ֱ�ӽ���");
		combobox.addItem("�����������");
		combobox.addItem("�������������");
		return combobox;
	}
}
