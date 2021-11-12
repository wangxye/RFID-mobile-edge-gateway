/**  
* <p>Title: MObserver.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019年7月30日  
* @version 1.0  
*/
package com.rfid.monitor;

import com.rfid.bean.MessageTran;
import com.rfid.main.basicOperation.BasicOperate;
import com.rfid.main.basicOperation.BasicTable;
import com.rfid.main.deviceParams.DataEntryCloud;
import com.rfid.main.tool.RFIDUtil;
import com.rfid.rxobserver.RXObserver;
import com.rfid.rxobserver.ReaderSetting;
import com.rfid.rxobserver.bean.RXInventoryTag;
import com.rfid.rxobserver.bean.RXInventoryTag.RXFastSwitchAntInventoryTagEnd;
import com.rfid.rxobserver.bean.RXInventoryTag.RXInventoryTagEnd;
import com.rfid.rxobserver.bean.RXOperationTag;

/**
 * <p>
 * Title: MObserver
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019年7月30日
 */
public class MObserver extends RXObserver {

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: refreshSetting</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param readerSetting
	 * 
	 * @see com.rfid.rxobserver.RXObserver#refreshSetting(com.rfid.rxobserver.
	 * ReaderSetting)
	 * 
	 */
	@Override
	protected void refreshSetting(ReaderSetting readerSetting) {
		// TODO Auto-generated method stub
		super.refreshSetting(readerSetting);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onExeCMDStatus</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param cmd
	 * 
	 * @param status
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onExeCMDStatus(byte, byte)
	 * 
	 */
	@Override
	protected void onExeCMDStatus(byte cmd, byte status) {
		// TODO Auto-generated method stub
		super.onExeCMDStatus(cmd, status);
		System.out.format("CDM:%s  Execute status:%S", String.format("%02X", cmd), String.format("%02x", status));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onInventoryTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param tag
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onInventoryTag(com.rfid.rxobserver.bean.
	 * RXInventoryTag)
	 * 
	 */
	@Override
	protected void onInventoryTag(RXInventoryTag tag) {
		// TODO Auto-generated method stub
		super.onInventoryTag(tag);
		System.out.println("EPC data:" + tag.strEPC);
		if (RFIDUtil.isData) {
			if (RFIDUtil.mode == 1) {
				DataEntryCloud.showCategory(tag);
			} else {
				DataEntryCloud.insertCategory(tag);
			}

			RFIDUtil.isData = false;
			RFIDUtil.mode = 0;
		} else {
			if (!RFIDUtil.isStop) {
				BasicTable.tableInfoShow(tag);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onInventoryTagEnd</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param tagEnd
	 * 
	 * @see
	 * com.rfid.rxobserver.RXObserver#onInventoryTagEnd(com.rfid.rxobserver.bean.
	 * RXInventoryTag.RXInventoryTagEnd)
	 * 
	 */
	@Override
	protected void onInventoryTagEnd(RXInventoryTagEnd tagEnd) {
		// TODO Auto-generated method stub
		super.onInventoryTagEnd(tagEnd);
		System.out.println("inventory end:" + tagEnd.mTotalRead);
		if (tagEnd.mTotalRead == 0) {
			BasicOperate.inventoryOnce();
		}
		if (RFIDUtil.isContinue) {
			BasicOperate.start();
		}
		RFIDUtil.isStop = false;
//		BasicOperate.inventoryOnce();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onFastSwitchAntInventoryTagEnd</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param tagEnd
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onFastSwitchAntInventoryTagEnd(com.rfid.
	 * rxobserver.bean.RXInventoryTag.RXFastSwitchAntInventoryTagEnd)
	 * 
	 */
	@Override
	protected void onFastSwitchAntInventoryTagEnd(RXFastSwitchAntInventoryTagEnd tagEnd) {
		// TODO Auto-generated method stub
		super.onFastSwitchAntInventoryTagEnd(tagEnd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onInventory6BTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param nAntID
	 * 
	 * @param strUID
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onInventory6BTag(byte, java.lang.String)
	 * 
	 */
	@Override
	protected void onInventory6BTag(byte nAntID, String strUID) {
		// TODO Auto-generated method stub
		super.onInventory6BTag(nAntID, strUID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onInventory6BTagEnd</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param nTagCount
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onInventory6BTagEnd(int)
	 * 
	 */
	@Override
	protected void onInventory6BTagEnd(int nTagCount) {
		// TODO Auto-generated method stub
		super.onInventory6BTagEnd(nTagCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onRead6BTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param antID
	 * 
	 * @param strData
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onRead6BTag(byte, java.lang.String)
	 * 
	 */
	@Override
	protected void onRead6BTag(byte antID, String strData) {
		// TODO Auto-generated method stub
		super.onRead6BTag(antID, strData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onWrite6BTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param nAntID
	 * 
	 * @param nWriteLen
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onWrite6BTag(byte, byte)
	 * 
	 */
	@Override
	protected void onWrite6BTag(byte nAntID, byte nWriteLen) {
		// TODO Auto-generated method stub
		super.onWrite6BTag(nAntID, nWriteLen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onLock6BTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param nAntID
	 * 
	 * @param nStatus
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onLock6BTag(byte, byte)
	 * 
	 */
	@Override
	protected void onLock6BTag(byte nAntID, byte nStatus) {
		// TODO Auto-generated method stub
		super.onLock6BTag(nAntID, nStatus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onLockQuery6BTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param nAntID
	 * 
	 * @param nStatus
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onLockQuery6BTag(byte, byte)
	 * 
	 */
	@Override
	protected void onLockQuery6BTag(byte nAntID, byte nStatus) {
		// TODO Auto-generated method stub
		super.onLockQuery6BTag(nAntID, nStatus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onGetInventoryBufferTagCount</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param nTagCount
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onGetInventoryBufferTagCount(int)
	 * 
	 */
	@Override
	protected void onGetInventoryBufferTagCount(int nTagCount) {
		// TODO Auto-generated method stub
		super.onGetInventoryBufferTagCount(nTagCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onOperationTag</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param tag
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onOperationTag(com.rfid.rxobserver.bean.
	 * RXOperationTag)
	 * 
	 */
	@Override
	protected void onOperationTag(RXOperationTag tag) {
		// TODO Auto-generated method stub
		super.onOperationTag(tag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onOperationTagEnd</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param operationTagCount
	 * 
	 * @see com.rfid.rxobserver.RXObserver#onOperationTagEnd(int)
	 * 
	 */
	@Override
	protected void onOperationTagEnd(int operationTagCount) {
		// TODO Auto-generated method stub
		super.onOperationTagEnd(operationTagCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onConfigTagMask</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param msgTran
	 * 
	 * @see
	 * com.rfid.rxobserver.RXObserver#onConfigTagMask(com.rfid.bean.MessageTran)
	 * 
	 */
	@Override
	protected void onConfigTagMask(MessageTran msgTran) {
		// TODO Auto-generated method stub
		super.onConfigTagMask(msgTran);
	}

}
