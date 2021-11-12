package com.rfid.main.deviceParams;

import javax.swing.JComboBox;

/**
 * 天线参数设置
 * 
 * @author zhuQixiang
 * 
 */
public class AntennaParameter {

	/**
	 * 天线信号读取的速度选项列表
	 * 
	 * @param combo 下拉框控件
	 * @return 下拉列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxSecond(JComboBox combobox) {
		for (int i = 360; i >= 0; i = i - 10) {
			combobox.addItem(i);
		}
		return combobox;
	}

	/**
	 * 天线信号读取的选项列表，DBM毫瓦
	 * 
	 * @param combo 下拉框控件
	 * @return 下拉列表
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
		combobox.addItem("接收方式");
		combobox.addItem("直接接收");
		combobox.addItem("过耦合器接收");
		combobox.addItem("不过耦合器接收");
		return combobox;
	}
}
