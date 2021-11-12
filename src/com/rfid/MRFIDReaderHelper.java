/**  
* <p>Title: MRFIDReaderHelper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020��4��25��  
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
 * @date 2020��4��25��
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
	 * Set Tx Channel. �ı䷢��ͨ��
	 * 
	 * @param btReadId    Reader Address(0xFF Public Address)
	 * @param btTxChannel Tx Channel(0x00:�ر��������Ӽ��,����λÿһλ�ֱ����һ�����ߣ����磺0000 0011 =
	 *                    0x03�����1ͨ���Լ���2ͨ��������)
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
	 * Set output power(Set the different output power for 4 antennas).�ı䷢�书�� <br>
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
	 * Set Rx Channel �ı����ͨ��
	 * 
	 * @param btReadId    Reader Address(0xFF Public Address)
	 * @param btRxMode    regulation(0x00:�����������߽���, 0x01:���л�����ֱ�ӽ���, 0x02:�����������)
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
	 * Set Rx Position(Set the different output power for 4 antennas).�ı������λ <br>
	 *
	 * @param btReadId  Reader Address(0xFF Public Address)
	 * @param btChannel ����Ҫ���õ�ͨ���ã�1��2��3��4�ֱ������Ҫ���õ�ͨ����
	 * @param btNub     ����Ҫ���õ���λ����
	 * @param btP1_H    ������ʼ��λ�ĸ�8λ����λ���ܳ���255������Ҫ2���ֽڱ�ʾ��
	 * @param btP1_L    ������ʼ��λ�ĵ�8λ����λ���ܳ���255������Ҫ2���ֽڱ�ʾ��
	 * @param btP2_H    ���ý�����λ�ĸ�8λ����λ���ܳ���255������Ҫ2���ֽڱ�ʾ��
	 * @param btP2_L    ���ý�����λ�ĸ�8λ����λ���ܳ���255������Ҫ2���ֽڱ�ʾ��
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
