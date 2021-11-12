package com.rfid.main.basicOperation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.main.test.RFIDdemo;

/**
 * <p>
 * Title: BasicOperateOnclick
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019Äê7ÔÂ22ÈÕ
 */
public class BasicOperateOnclick extends RFIDdemo {
	private static final long serialVersionUID = 1L;

	public static void onclick() {
		// TODO Auto-generated method stub

		btnAddIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.addIP();
			}
		});

		btnAddSerial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasicOperate.addSerial();

			}
		});

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.refresh();
			}
		});

		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.refreshCOM();
			}
		});

//		rdoNet.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (R2kUtil.r2ks[0] != null) {
//					BasicOperate.disconnect();
//				}
//				BasicTree.getDeviceIP(model, tree_onlineDevice, nodeTree, node_1);
//				TreeNode root = (TreeNode) tree_onlineDevice.getModel().getRoot();
//				model.reload(root);
//			}
//		});
//		rdoSerialPort.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (R2kUtil.r2ks[0] != null) {
//					BasicOperate.disconnect();
//				}
//				BasicTree.getDeviceComm(model, tree_onlineDevice, nodeTree, node_1);
//				TreeNode root = (TreeNode) tree_onlineDevice.getModel().getRoot();
//				model.reload(root);
//			}
//		});
//		
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.disconnect();
			}
		});

		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.connect();
			}
		});

		btnClearData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// total labels count
				labelCount.setText("0");
				labelTagCount.setText("0");
				tableModel.setRowCount(0);
			}
		});

		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.stopReadCard();
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.start();
			}
		});

		btnInventoryOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicOperate.inventoryOnce();
			}
		});
	}

}
