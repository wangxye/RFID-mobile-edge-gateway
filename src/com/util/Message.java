package com.util;

import javax.swing.JOptionPane;

/**
 * ������Ϣ��ʾ
 * 
 * @author
 * 
 */
public class Message {
	/**
	 * 
	 * @param content �Ի�������ʾ����
	 * @param title   �Ի������
	 */
	public static void Show(String contaier, String title) {
		JOptionPane.showMessageDialog(null, contaier, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
