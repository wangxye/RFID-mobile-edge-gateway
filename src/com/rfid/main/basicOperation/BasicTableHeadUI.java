package com.rfid.main.basicOperation;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;

import com.main.test.RFIDdemo;

/**
 * <p>
 * Title: BasicTableHeadUI
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019��7��24��
 */
public class BasicTableHeadUI extends BasicTableHeaderUI {
	private JTableHeader header;

	public void paint(Graphics g, JComponent c) {
		header = (JTableHeader) c;
		JLabel label = getLabel(RFIDdemo.rs.getString("strLvHeadNo"));
		rendererPane.paintComponent(g, label, header, getX(0), 1, getWidth(0), 20, true);
		label = getLabel(RFIDdemo.rs.getString("strLvHeadEPC"));
		rendererPane.paintComponent(g, label, header, getX(1), 2, getWidth(1), 20, true);
		label = getLabel(RFIDdemo.rs.getString("strLvHeadCount"));
		rendererPane.paintComponent(g, label, header, getX(2), 1, getWidth(2), 20, true);
		label = getLabel(RFIDdemo.rs.getString("strLvHeadAntNo"));
		rendererPane.paintComponent(g, label, header, getX(3), 1, getWidth(3), 20, true);
		label = getLabel(RFIDdemo.rs.getString("strLvHeadDevNo"));
		rendererPane.paintComponent(g, label, header, getX(4), 1, getWidth(4), 20, true);
	}

	/**
	 * ��ȡָ���е���ʼ����
	 * 
	 * @param column ��
	 * @return x�����λ��
	 */
	private int getX(int column) {
		int x = 0;
		for (int i = 0; i < column; i++) {
			x += header.getColumnModel().getColumn(i).getWidth();
		}
		return x;
	}

	/**
	 * ָ���еĿ��
	 * 
	 * @param column ��
	 * @return ���
	 */
	private int getWidth(int column) {
		return header.getColumnModel().getColumn(column).getWidth();
	}

	/**
	 * ���ָ���ı��ı�ǩ
	 * 
	 * @param text ��ͷ����
	 * @return ��ͷ�ı���
	 */
	private JLabel getLabel(String text) {
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		return label;
	}
}