/**  
* <p>Title: ImpinjRFIDReaderHelper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年4月28日  
* @version 1.0  
*/
package com.rfid.service;

import java.util.Observer;

import com.module.interaction.RXTXListener;
import com.rfid.RFIDReaderHelper;
import com.rfid.ReaderConnector;
import com.rfid.main.tool.RFIDUtil;
import com.rfid.monitor.MObserver;
import com.rfid.monitor.MRXTListener;

/**
 * <p>
 * Title: ImpinjRFIDReaderHelper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年4月28日
 */
public class ImpinjRFIDReaderHelper implements RFIDOperation {

	private String IP;

	private Integer Port;

	private byte btReadId;

	private RFIDReaderHelper mReaderHelper;

	private final ReaderConnector mConnector;

	private Observer mObserver;

	private Observer mObserver1;

	private RXTXListener mListener;

	/**
	 * @return the iP
	 */
	public String getIP() {
		return IP;
	}

	/**
	 * @param iP the iP to set
	 */
	public void setIP(String iP) {
		IP = iP;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return Port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		Port = port;
	}

	/**
	 * @return the btReadId
	 */
	public byte getBtReadId() {
		return btReadId;
	}

	/**
	 * @param btReadId the btReadId to set
	 */
	public void setBtReadId(byte btReadId) {
		this.btReadId = btReadId;
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param iP
	 * @param port
	 * @param btReadId
	 */
	public ImpinjRFIDReaderHelper(String iP, Integer port, byte btReadId) {
		super();
		IP = iP;
		Port = port;
		this.btReadId = btReadId;
		mConnector = new ReaderConnector();
		mObserver = new MObserver();
		mObserver1 = new MObserver();
		mListener = new MRXTListener();
	}

	@Override
	public void connect() {
		mReaderHelper = (RFIDReaderHelper) mConnector.connectNet(IP, Port);
		mReaderHelper.registerObserver(mObserver);
		mReaderHelper.registerObserver(mObserver1);
		mReaderHelper.setRXTXListener(mListener);
	}

	@Override
	public Integer disconnect() {
		mReaderHelper.unRegisterObserver(mObserver);
		mReaderHelper.unRegisterObserver(mObserver1);
		Integer result = mReaderHelper.reset(btReadId);
		mReaderHelper.signOut();
		mConnector.disConnect();
		return result;

	}

	@Override
	public Integer startReader(byte btRepeat) {
		RFIDUtil.isContinue = true;
		(mReaderHelper).setWorkAntenna(btReadId, (byte) 0x00);
//		(mReaderHelper).setWorkAntenna((byte) 0xff, (byte)0x01);
//		(mReaderHelper).setWorkAntenna((byte) 0xff, (byte)0x02);
//		(mReaderHelper).setWorkAntenna((byte) 0xff, (byte)0x03);
		// (mReaderHelper).customizedSessionTargetInventory(btReadId, (byte)0x02,
		// (byte)0x00 , btRepeat);
		return mReaderHelper.realTimeInventory(btReadId, btRepeat);
	}

	@Override
	public Integer inventoryOnce() {
		(mReaderHelper).setWorkAntenna(btReadId, (byte) 0x00);
		return mReaderHelper.realTimeInventory(btReadId, (byte) 0xff);
	}

	@Override
	public Integer setAntParamPower(byte[] Ant, int[] power) {
		return mReaderHelper.setOutputPower(btReadId, (byte) power[0], (byte) power[1], (byte) power[2],
				(byte) power[3]);
	}

	@Override
	public Integer getAntParamPower() {
		return mReaderHelper.getOutputPower(btReadId);
	}

	@Override
	public Integer setAntParamPort(int Region, int port_low, int port_high) {
		return mReaderHelper.setFrequencyRegion(btReadId, (byte) Region, (byte) port_low, (byte) port_high);
	}

	@Override
	public Integer getAntParamPort() {
		return mReaderHelper.getFrequencyRegion(btReadId);
	}

	@Override
	public Integer stopReadCard() {
		RFIDUtil.isStop = true;
		RFIDUtil.isContinue = false;
//		mReaderHelper.setAntConnectionDetector((byte)0xff, (byte)0x00);
//		return mReaderHelper.reset(btReadId);
		return 1;
	}

}
