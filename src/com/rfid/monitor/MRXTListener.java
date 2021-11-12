/**  
* <p>Title: MRXTListener.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019年7月30日  
* @version 1.0  
*/
package com.rfid.monitor;

import com.module.interaction.RXTXListener;
import com.rfid.main.deviceParams.DeviceEchoData;
import com.util.StringTool;

/**
 * <p>
 * Title: MRXTListener
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019年7月30日
 */
public class MRXTListener implements RXTXListener {

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: reciveData</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param btAryReceiveData
	 * 
	 * @see com.module.interaction.RXTXListener#reciveData(byte[])
	 * 
	 */
	@Override
	public void reciveData(byte[] btAryReceiveData) {
		// TODO Auto-generated method stub
		System.out.println("reciveData" + StringTool.byteArrayToString(btAryReceiveData, 0, btAryReceiveData.length));
		System.out.println(btAryReceiveData[3]);
		switch (btAryReceiveData[3]) {
		case 119:
			System.out.println("读取天线功率");
			DeviceEchoData.echoPower(btAryReceiveData);
			break;
		case 121:
			System.out.println("读取频点范围功率");
			DeviceEchoData.echoPort(btAryReceiveData);
			break;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: sendData</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param btArySendData
	 * 
	 * @see com.module.interaction.RXTXListener#sendData(byte[])
	 * 
	 */
	@Override
	public void sendData(byte[] btArySendData) {
		// TODO Auto-generated method stub
		System.out.println("sendData" + StringTool.byteArrayToString(btArySendData, 0, btArySendData.length));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: onLostConnect</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * 
	 * @see com.module.interaction.RXTXListener#onLostConnect()
	 * 
	 */
	@Override
	public void onLostConnect() {
		System.out.println("连接断线");
//		BasicOperate.connect();

	}

}
