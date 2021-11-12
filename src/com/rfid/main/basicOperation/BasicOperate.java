/**  
* <p>Title: BasicOperate.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019年7月27日  
* @version 1.0  
*/
package com.rfid.main.basicOperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.main.test.RFIDdemo;
import com.rfid.main.tool.RFIDUtil;
import com.rfid.service.IRFIDReaderHelper;
import com.rfid.service.ImpinjRFIDReaderHelper;
import com.util.Message;
import com.util.Validation;

/**
 * <p>
 * Title: BasicOperate
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019年7月27日
 */
public class BasicOperate extends RFIDdemo {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Title: addIP
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void addIP() {
		MutableTreeNode nodeNew = new DefaultMutableTreeNode();
		// 获取选中的树形节点
		// TreePath path = tree_onlineDevice.getSelectionPath();
		TreePath path = tree_onlineDevice.getPathForRow(0);
		MutableTreeNode nodePar = (MutableTreeNode) path.getLastPathComponent();
		int count = nodePar.getChildCount();
		String addIPAddress = txtIP.getText() + ":" + txtIPPort.getText();
//		String addIPPort = txtIPPort.getText();
//		if (!Regex.isValidIP(addIPAddress)||!Validation.isPort(addIPPort)) {
//			Message.Show(RFIDdemo.rs.getString("strMsgFailed"), "");
//			return;
//		}
		if (!Validation.isValidIP(addIPAddress)) {
			Message.Show(RFIDdemo.rs.getString("strMsgFailed"), "");
			return;
		}

		nodeNew.setUserObject(addIPAddress);
		model.insertNodeInto(nodeNew, nodePar, count);
		TreePath NewPath = path.pathByAddingChild(nodeNew);
		if (!tree_onlineDevice.isVisible(NewPath)) {
			tree_onlineDevice.makeVisible(NewPath);
		}
	}

	/**
	 * <p>
	 * Title: refresh
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void refresh() {
		// TODO Auto-generated method stub
		if (RFIDUtil.mReaderHelper[0] != null) {
			BasicOperate.disconnect();
			note = null;
		}
		BasicTree.getDeviceIP(model, tree_onlineDevice, nodeTree, node_1);
		TreeNode root = (TreeNode) tree_onlineDevice.getModel().getRoot();
		model.reload(root);
//		if (rdoNet.isSelected()) {
//			BasicTree.getDeviceIP(model, tree_onlineDevice, nodeTree, node_1);
//			TreeNode root = (TreeNode) tree_onlineDevice.getModel().getRoot();
//			model.reload(root);
//		} else if (rdoSerialPort.isSelected()) {
//			BasicTree.getDeviceComm(model, tree_onlineDevice, nodeTree, node_1);
//			TreeNode root = (TreeNode) tree_onlineDevice.getModel().getRoot();
//			model.reload(root);
//		}
	}

	/**
	 * <p>
	 * Title: disconnect
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void disconnect() {
		// TODO Auto-generated method stub
		boolean isConn = false;
		try {
			for (int i = 0; i < RFIDUtil.MAX_DEVICE_NUM && RFIDUtil.mReaderHelper[i] != null; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					int isrest = (RFIDUtil.mReaderHelper[i]).disconnect();
					if (isrest == 0) {
						RFIDUtil.mReaderHelper[i] = null;
						isConn = true;
						isContinueReadCard = false;
						System.out.println("成功断开");
						RFIDUtil.isConn = false;
						note = (DefaultMutableTreeNode) tree_onlineDevice.getLastSelectedPathComponent();
						// 获取选中节点的父节点
						parent = (DefaultMutableTreeNode) note.getParent();
						// 获取选中的IP或串口号
						String ipOrComm = note.toString();
						String ipComm = ipOrComm.substring(0, ipOrComm.length() - 7) + "_Offline";
						TreePath path = tree_onlineDevice.getSelectionPath();
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
						node.setUserObject(ipComm);
						System.out.println(ipComm);
						model.nodeChanged(node);
						tree_onlineDevice.setSelectionPath(path);
						// repaint();
						tree_onlineDevice.updateUI();
					}
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
//			if (rdoSerialPort.isSelected()) {
//				BasicTree.getDeviceComm(model, tree_onlineDevice, nodeTree,node_1);
//				tree_onlineDevice.updateUI();
//			} else {
//				BasicTree.getDeviceIP(model, tree_onlineDevice, nodeTree,node_1);
//				tree_onlineDevice.updateUI();
//			}

		} catch (Exception ex) {
			Message.Show(rs.getString("MsgConnectionfailure"), "");// "连接断开失败");
		}
	}

	/**
	 * <p>
	 * Title: connect
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void connect() {
		// TODO Auto-generated method stub
		// 获取当前节点值
		note = (DefaultMutableTreeNode) tree_onlineDevice.getLastSelectedPathComponent();
		System.out.println(note);
		try {
			if (null == note || note.toString().equals(rs.getString("LVOnlineEquipment"))) {
				Message.Show(rs.getString("MsgChoosebtnConnect"), "");
				return;
			}
			// 获取选中节点的父节点
			parent = (DefaultMutableTreeNode) note.getParent();
			// 获取选中的IP或串口号
			String ipOrComm = note.toString();
			Pattern p = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)");
			Matcher m = p.matcher(ipOrComm);
			String IP = null;
			Integer Port = null;
			while (m.find()) {
				IP = m.group(1);
				Port = Integer.valueOf(m.group(2));
				ipOrComm = IP + ":" + Port;
			}
			int i = 0;
			for (; i < RFIDUtil.MAX_DEVICE_NUM; i++) {
				if (RFIDUtil.mReaderHelper[i] == null) {
					if (cbotype_net.getSelectedIndex() == 0) {
						ImpinjRFIDReaderHelper impinjRFIDReaderHelper = new ImpinjRFIDReaderHelper(IP, Port,
								(byte) 0xff);
						impinjRFIDReaderHelper.connect();
						RFIDUtil.mReaderHelper[i] = impinjRFIDReaderHelper;
					} else {
						IRFIDReaderHelper iReaderHelper = new IRFIDReaderHelper(IP, Port, (byte) 0xff);
						iReaderHelper.connect();
						RFIDUtil.mReaderHelper[i] = iReaderHelper;
					}
					RFIDUtil.isConn = true;
					break;
				}
			}
			if (RFIDUtil.mReaderHelper[i] == null) {
				Message.Show(RFIDdemo.rs.getString("MsgChooseConnectFail"), "");
				return;
			}
			if (i == RFIDUtil.MAX_DEVICE_NUM) {
				Message.Show(rs.getString("MsgChoosebtnConnectOut"), "");// "连接设备数已达上限");
				return;
			}
			if (null != RFIDUtil.mReaderHelper[i]) {
				String ipConn = ipOrComm + "_Online";// "_已连接"
				btnDisconnect.setEnabled(true);
				btnStart.setEnabled(true);
				btnInventoryOnce.setEnabled(true);
//				btnReadBuffer.setEnabled(true);
//				btnClearBuffer.setEnabled(true);
				TreePath path = tree_onlineDevice.getSelectionPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
				node.setUserObject(ipConn);
				model.nodeChanged(node);
				tree_onlineDevice.setSelectionPath(path);
				// repaint();
				tree_onlineDevice.updateUI();
			}
		} catch (Exception ex) {
			Message.Show(rs.getString("MsgChooseConnectFail"), "");
		}

	}

	/**
	 * <p>
	 * Title: stopReadCard
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void stopReadCard() {
		// TODO Auto-generated method stub
		boolean isConn = false;
		try {
			for (int i = 0; i < RFIDUtil.MAX_DEVICE_NUM && RFIDUtil.mReaderHelper[i] != null; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					(RFIDUtil.mReaderHelper[i]).stopReadCard();
//					rrh.signOut();
					isConn = true;
					btnStop.setEnabled(false);
					isContinueReadCard = false;
					// BasicOperate.buttonSet(true);
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
		} catch (Exception ex) {
			Message.Show(rs.getString("MsgExStopInv"), "");
		}
	}

	/**
	 * <p>
	 * Title: start
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void start() {
		// TODO Auto-generated method stub
		if (isContinueReadCard && !RFIDUtil.isContinue) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		}
		boolean isConn = false;
		try {
			for (int i = 0; i < RFIDUtil.MAX_DEVICE_NUM && RFIDUtil.mReaderHelper[i] != null; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					isConn = true;
					(RFIDUtil.mReaderHelper[i]).startReader((byte) 0x0f);
					btnStop.setEnabled(true);
					isContinueReadCard = true;
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
		} catch (Exception ex) {
			Message.Show(rs.getString("MsgExInvOnce"), "");
		}
	}

	/**
	 * <p>
	 * Title: inventoryOnce
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void inventoryOnce() {
		// TODO Auto-generated method stub
		System.out.println(isContinueReadCard);
		if (isContinueReadCard) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		}
		try {
			for (int i = 0; i < RFIDUtil.MAX_DEVICE_NUM && RFIDUtil.mReaderHelper[i] != null; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					(RFIDUtil.mReaderHelper[i]).inventoryOnce();

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			Message.Show(rs.getString("MsgExInvOnce"), "");
		}

	}

	/**
	 * <p>
	 * Title: addSerial
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void addSerial() {

	}

	/**
	 * <p>
	 * Title: refreshCOM
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public static void refreshCOM() {
		// TODO Auto-generated method stub
		if (RFIDUtil.mReaderHelper[0] != null) {
			BasicOperate.disconnect();
			note = null;
		}
		BasicTree.getDeviceComm(model, tree_onlineDevice, nodeTree, node_1);
		TreeNode root = (TreeNode) tree_onlineDevice.getModel().getRoot();
		model.reload(root);
	}

}
