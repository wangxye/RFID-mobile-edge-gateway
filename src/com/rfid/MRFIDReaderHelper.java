/**  
* <p>Title: MRFIDReaderHelper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年4月25日  
* @version 1.0  
*/
package com.rfid;

import com.rfid.bean.MessageTran;
import com.rfid.config.CMD;

/**
 * <p>
 * Title: MRFIDReaderHelper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年4月25日
 */
public class MRFIDReaderHelper extends RFIDReaderHelper {

//    private int sendMessage(byte btReadId, byte btCmd) {
//        MessageTran msgTran = new MessageTran(btReadId, btCmd);
//        return sendCommand(msgTran.getAryTranData());
//    }

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	MRFIDReaderHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int sendMessage(byte btReadId, byte btCmd, byte[] btAryData) {
		MessageTran msgTran = new MessageTran(btReadId, btCmd, btAryData);
		return sendCommand(msgTran.getAryTranData());
	}

	/**
	 * Set Tx Channel. 改变发射通道
	 * 
	 * @param btReadId    Reader Address(0xFF Public Address)
	 * @param btTxChannel Tx Channel(0x00:关闭天线连接检测,低四位每一位分别代表一个天线，例如：0000 0011 =
	 *                    0x03代表第1通道以及第2通道工作。)
	 * @return Succeeded :0, Failed:-1
	 */
	public final int setTxChannel(byte btReadId, byte btTxChannel) {
		byte btCmd = CMD.SET_Tx_Channel;
		byte[] btAryData = new byte[1];

		btAryData[0] = btTxChannel;

		int nResult = sendMessage(btReadId, btCmd, btAryData);

		return nResult;
	}

	/**
	 * Set output power(Set the different output power for 4 antennas).改变发射功率 <br>
	 *
	 * @param btReadId   Reader Address(0xFF Public Address)
	 * @param btCH1Power Output power of antenna 1, range from 0 to 31.5(0x00 -
	 *                   0x1F), the unit is dBm.
	 * @param btCH2Power Output power of antenna 2, range from 0 to 31.5(0x00 -
	 *                   0x1F), the unit is dBm.
	 * @param btCH3Power Output power of antenna 3, range from 0 to 31.5(0x00 -
	 *                   0x1F), the unit is dBm.
	 * @param btCH4Power Output power of antenna 4, range from 0 to 31.5(0x00 -
	 *                   0x1F), the unit is dBm.
	 * @return Succeeded :0, Failed:-1
	 */
	public final int setCHPower(byte btReadId, byte btCH1Power, byte btCH2Power, byte btCH3Power, byte btCH4Power) {
		byte btCmd = CMD.SET_CH_Power;
		byte[] btAryData = new byte[4];

		btAryData[0] = btCH1Power;
		btAryData[1] = btCH2Power;
		btAryData[2] = btCH3Power;
		btAryData[3] = btCH4Power;

		int nResult = sendMessage(btReadId, btCmd, btAryData);

		return nResult;
	}

	/**
	 * Set Rx Channel 改变接收通道
	 * 
	 * @param btReadId    Reader Address(0xFF Public Address)
	 * @param btRxMode    regulation(0x00:单独接收天线接收, 0x01:过切换开关直接接收, 0x02:过耦合器接收)
	 * @param btRxChannel Start Rx Channel,
	 * @return Succeeded :0, Failed:-1
	 */
	public final int setRxChannel(byte btReadId, byte btRxMode, byte btRxChannel) {
		byte btCmd = CMD.SET_Rx_Channel;
		byte[] btAryData = new byte[2];

		btAryData[0] = btRxMode;
		btAryData[1] = btRxChannel;

		int nResult = sendMessage(btReadId, btCmd, btAryData);

		return nResult;
	}

	/**
	 * Set Rx Position(Set the different output power for 4 antennas).改变接收相位 <br>
	 *
	 * @param btReadId  Reader Address(0xFF Public Address)
	 * @param btChannel 代表要设置的通道好，1，2，3，4分别代表需要设置的通道号
	 * @param btNub     代表要设置的相位个数
	 * @param btP1_H    设置起始相位的高8位。相位可能超过255所有需要2个字节表示。
	 * @param btP1_L    设置起始相位的低8位。相位可能超过255所有需要2个字节表示。
	 * @param btP2_H    设置结束相位的高8位。相位可能超过255所有需要2个字节表示。
	 * @param btP2_L    设置结束相位的高8位。相位可能超过255所有需要2个字节表示。
	 * @return Succeeded :0, Failed:-1
	 */
	public final int setRxPosition(byte btReadId, byte btChannel, byte btNub, byte btP1_H, byte btP1_L, byte btP2_H,
			byte btP2_L) {
		byte btCmd = CMD.SET_Rx_Position;
		byte[] btAryData = new byte[6];

		btAryData[0] = btChannel;
		btAryData[1] = btNub;
		btAryData[2] = btP1_H;
		btAryData[3] = btP1_L;
		btAryData[4] = btP2_H;
		btAryData[5] = btP2_L;

		int nResult = sendMessage(btReadId, btCmd, btAryData);

		return nResult;
	}
}
