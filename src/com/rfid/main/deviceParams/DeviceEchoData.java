/**  
* <p>Title: DeviceEchoData.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年4月22日  
* @version 1.0  
*/
package com.rfid.main.deviceParams;

import com.main.test.RFIDdemo;

/**
 * <p>
 * Title: DeviceEchoData
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年4月22日
 */
public class DeviceEchoData extends RFIDdemo {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 223L;

	/**
	 * <p>
	 * Title: echoPower
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param btAryData reciveDataA0 07 01 77 1C 1E 1E 1E 6B reciveDataA0 04 01 77
	 *                  1E C6
	 */
	public static void echoPower(byte[] btAryData) {
//		System.out.println(btAryData);
		System.out.println(btAryData[1] == 4);
		if ((int) btAryData[1] == 4) {
			cboDeviceAntennaPower1.setSelectedItem((int) btAryData[4]);
			cboDeviceAntennaPower2.setSelectedItem((int) btAryData[4]);
			cboDeviceAntennaPower3.setSelectedItem((int) btAryData[4]);
			cboDeviceAntennaPower4.setSelectedItem((int) btAryData[4]);
		} else {
			cboDeviceAntennaPower1.setSelectedItem((int) btAryData[4]);
			cboDeviceAntennaPower2.setSelectedItem((int) btAryData[5]);
			cboDeviceAntennaPower3.setSelectedItem((int) btAryData[6]);
			cboDeviceAntennaPower4.setSelectedItem((int) btAryData[7]);
		}
	}

	/**
	 * <p>
	 * Title: echoPort
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param btAryData reciveDataA0 06 01 79 01 07 3B 9D
	 */
	public static void echoPort(byte[] btAryData) {
//		System.out.println(btAryData);
		System.out.println((int) btAryData[4]);
		switch ((int) btAryData[4]) {
		case 1:
			rdoFCC.setSelected(true);
			AntennaParameter.comboboxPort(cboPortlow, cboPorthigh, 902, 928);
			break;
		case 2:
			rdoETSI.setSelected(true);
			AntennaParameter.comboboxPort(cboPortlow, cboPorthigh, 865, 868);
			break;
		case 3:
			rdoCHN.setSelected(true);
			AntennaParameter.comboboxPort(cboPortlow, cboPorthigh, 920, 925);
			break;
		}

		Double low = 865 + (int) btAryData[5] * 0.5;
		Double high = 865 + (int) btAryData[6] * 0.5;
		if (btAryData[4] != 2) {
			low = 902 + (int) (btAryData[5] - 7) * 0.5;
			high = 902 + (int) (btAryData[6] - 7) * 0.5;
		}
		cboPortlow.setSelectedItem(low);
		cboPorthigh.setSelectedItem(high);

	}

}
