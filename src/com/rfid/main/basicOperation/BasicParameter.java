/**  
* <p>Title: BasicParameter.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年4月10日  
* @version 1.0  
*/
package com.rfid.main.basicOperation;

import javax.swing.JComboBox;

/**
 * <p>
 * Title: BasicParameter
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年4月10日
 */
public class BasicParameter {

	/**
	 * 串口号
	 * 
	 * @param combo 下拉框控件
	 * @return 下拉列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxSerial(JComboBox combobox) {
		for (int i = 1; i <= 16; i = i + 1) {
			combobox.addItem("COM" + i);
		}
		return combobox;
	}

	/**
	 * RS-232波特率
	 * 
	 * @param combo 下拉框控件
	 * @return 下拉列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxBaund(JComboBox combobox) {
		combobox.addItem(115200);
		combobox.addItem(38400);
		return combobox;
	}

	/**
	 * 读写器类型
	 * 
	 * @param combo 下拉框控件
	 * @return 下拉列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxType(JComboBox combobox) {
		combobox.addItem("Impinj");
		combobox.addItem("ZAH");
		return combobox;
	}

}
