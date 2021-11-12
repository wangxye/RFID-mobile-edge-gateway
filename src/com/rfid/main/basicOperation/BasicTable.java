package com.rfid.main.basicOperation;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import com.main.test.RFIDdemo;
import com.rfid.dao.impl.TagRecordDaoimpl;
import com.rfid.entity.TagRecord;
import com.rfid.rxobserver.bean.RXInventoryTag;

/**
 * <p>
 * Title: BasicTable
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019��7��22��
 */
public class BasicTable extends RFIDdemo {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Title: setTableStyle
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tbl_showTagInfo
	 */
	public static void setTableStyle(JTable tbl_showTagInfo) {
		// TODO Auto-generated method stub
		// ��ͷ���
		BasicTableHeadUI ui = new BasicTableHeadUI();
		// ���ͷ���������
		tbl_showTagInfo.getTableHeader().setUI(ui);

		// ���ñ�ͷ�Ĵ�С��Ҫ�������߶����Ҫ�ͱ�ͷ�ĸ߶�һ�����������ֶ��ಿ��
		tbl_showTagInfo.getTableHeader().setPreferredSize(new Dimension(450, 30));
		tbl_showTagInfo.setRowHeight(25);
		tbl_showTagInfo.setEnabled(false);
		// ����table���ݾ���
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
		tbl_showTagInfo.setDefaultRenderer(Object.class, tcr);
		// ����table��ͷ������ʾ
		((DefaultTableCellRenderer) tbl_showTagInfo.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		tbl_showTagInfo.setPreferredScrollableViewportSize(new Dimension(500, 260));
		// �����п�
		TableColumn firsetColumn = tbl_showTagInfo.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(50);
		firsetColumn.setMaxWidth(50);
		firsetColumn.setMinWidth(50);

		TableColumn secondColumn = tbl_showTagInfo.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(250);
		secondColumn.setMaxWidth(250);
		secondColumn.setMinWidth(250);
	}

	public static void tableInfoShow(RXInventoryTag tag) {
//		System.out.println("AntId data:" + tag.btAntId);
//		System.out.println("RSSI data:" + tag.strRSSI);
		String EPC = tag.strEPC;
		byte AntId = tag.btAntId;
		String RSSI = tag.strRSSI;
		String deviceId = note.toString().substring(0, 13);
		System.out.println(deviceId);
//		try {
//			if (chooseSaveFile) {
//				FileOperation.writeFile(tag.strEPC.getBytes());
//			}
//		} catch (Exception e) {
//			// e.printStackTrace();
//			Message.Show(rs.getString("strMsgFailedSaveFile"), "");
//		}
		boolean flag = false;
		TagRecordDaoimpl dao = new TagRecordDaoimpl();
		for (int j = 0; j < RFIDdemo.tbl_showTagInfo.getRowCount(); j++) {
			// ���������������뼯�����ݶԱ�,������������ͬ�����������Ӷ�ȡ�Ĵ���
			String rows = (String) RFIDdemo.tbl_showTagInfo.getValueAt(j, 1);
			byte ant = Byte.parseByte(RFIDdemo.tbl_showTagInfo.getValueAt(j, 3).toString());
			String device = RFIDdemo.tbl_showTagInfo.getValueAt(j, 4).toString();
			if (rows.equals(EPC) && (byte) ant == AntId && device.equals(deviceId)) {
				int count = Integer.parseInt(RFIDdemo.tbl_showTagInfo.getValueAt(j, 2).toString());
				count++;
				RFIDdemo.tbl_showTagInfo.setValueAt(count, j, 2);
				flag = true;
				TagRecord tr = new TagRecord();
				tr.setEPC(EPC);
				tr.setAntNo(AntId);
				tr.setHost(deviceId);
				tr.setRssi(RSSI);
				dao.insert(tr);
				break;
			}
		}
		if (!flag) {
			// ��ȡ�����е�����
			Object[] rowValues = { RFIDdemo.tbl_showTagInfo.getRowCount() + 1, EPC, 1, AntId, deviceId };
			RFIDdemo.tableModel.addRow(rowValues); // ���һ��
			TagRecord tr = new TagRecord();
			tr.setEPC(EPC);
			tr.setAntNo(AntId);
			tr.setHost(deviceId);
			tr.setRssi(RSSI);
			dao.insert(tr);
		}
		// ��������Ĵ���
		int cardResultTime = 0;
		for (int i = 0; i < RFIDdemo.tbl_showTagInfo.getRowCount(); i++) {
			cardResultTime += Integer.parseInt(RFIDdemo.tbl_showTagInfo.getValueAt(i, 2).toString());
		}
		RFIDdemo.labelCount.setText(String.valueOf(cardResultTime));
		// �ܹ��м��ű�ǩ
		RFIDdemo.labelTagCount.setText(String.valueOf(RFIDdemo.tbl_showTagInfo.getRowCount()));

	}

}
