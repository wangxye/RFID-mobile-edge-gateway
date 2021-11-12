/**  
* <p>Title: BasicParameter.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020��4��10��  
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
 * @date 2020��4��10��
 */
public class BasicParameter {

	/**
	 * ���ں�
	 * 
	 * @param combo ������ؼ�
	 * @return �����б�
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxSerial(JComboBox combobox) {
		for (int i = 1; i <= 16; i = i + 1) {
			combobox.addItem("COM" + i);
		}
		return combobox;
	}

	/**
	 * RS-232������
	 * 
	 * @param combo ������ؼ�
	 * @return �����б�
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxBaund(JComboBox combobox) {
		combobox.addItem(115200);
		combobox.addItem(38400);
		return combobox;
	}

	/**
	 * ��д������
	 * 
	 * @param combo ������ؼ�
	 * @return �����б�
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox comboboxType(JComboBox combobox) {
		combobox.addItem("Impinj");
		combobox.addItem("ZAH");
		return combobox;
	}

}
