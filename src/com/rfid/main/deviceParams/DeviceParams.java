package com.rfid.main.deviceParams;

import java.io.File;
import java.io.IOException;

import com.main.test.RFIDdemo;
import com.rfid.MRFIDReaderHelper;
import com.rfid.entity.Category;
import com.rfid.main.basicOperation.BasicOperate;
import com.rfid.main.tool.RFIDUtil;
import com.rfid.service.ImpinjRFIDReaderHelper;
import com.util.Message;
import com.util.PropertiesUtils;
import com.util.StringTool;
import com.util.Validation;

public class DeviceParams extends RFIDdemo {

	private static final long serialVersionUID = 1L;
	/**
	 * 保存文件夹
	 */
	private static String filePath = System.getProperty("user.dir").replace("\\", "/") + "/data.properties";
	/**
	 * 文件读写工具类
	 */
	private static PropertiesUtils property;
	/**
	 * 文件读取
	 */
	private static File file;
	/**
	 * 天线发射通道
	 */
	private static byte[] antLaunch = new byte[5];
	/**
	 * 天线接收通道
	 */
	private static byte[] antRecieve = new byte[4];
	/**
	 * 天线向角
	 */
	private static int[] dwellTime = new int[5];
	/**
	 * 天线功率
	 */
	private static int[] power = new int[5];
	/**
	 * 天线工作频点范围
	 */
	private static double[] port = new double[2];
	/**
	 * 天线工作频点模式
	 */
	private static int Region;
	/**
	 * 天线接收模式
	 */
	private static int mode;

	/**
	 * 设置天线 1号,2号,3号,4号
	 */
	public static void setAntParam() {
		if (isContinueReadCard) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		}
		labelShowInfo.setText("");
		boolean isConn = false;

		if (cboRecieveAntennaType.getSelectedIndex() > 1) {
			antRecieve[0] = (byte) (rdoRecieveAntenna1.isSelected() ? 1 : 0);
			antRecieve[1] = (byte) (rdoRecieveAntenna2.isSelected() ? 1 : 0);
			antRecieve[2] = (byte) (rdoRecieveAntenna3.isSelected() ? 1 : 0);
			antRecieve[3] = (byte) (rdoRecieveAntenna4.isSelected() ? 1 : 0);
			mode = cboRecieveAntennaType.getSelectedIndex() - 1;
		}

		// cboDeviceAntennaWorkTime4
		// cboDeviceAntennaPower1
		antLaunch[0] = (byte) (chkDeviceAntenna1.isSelected() ? 1 : 0);
		antLaunch[1] = (byte) (chkDeviceAntenna2.isSelected() ? 1 : 0);
		antLaunch[2] = (byte) (chkDeviceAntenna3.isSelected() ? 1 : 0);
		antLaunch[3] = (byte) (chkDeviceAntenna4.isSelected() ? 1 : 0);

		dwellTime[0] = Integer.parseInt(cboDeviceAntennaWorkTime1.getSelectedItem().toString());
		dwellTime[1] = Integer.parseInt(cboDeviceAntennaWorkTime2.getSelectedItem().toString());
		dwellTime[2] = Integer.parseInt(cboDeviceAntennaWorkTime3.getSelectedItem().toString());
		dwellTime[3] = Integer.parseInt(cboDeviceAntennaWorkTime4.getSelectedItem().toString());
		dwellTime[4] = Integer.parseInt(cboDeviceAntennaWorkTime5.getSelectedItem().toString());

		power[0] = Integer.parseInt(cboDeviceAntennaPower1.getSelectedItem().toString());
		power[1] = Integer.parseInt(cboDeviceAntennaPower2.getSelectedItem().toString());
		power[2] = Integer.parseInt(cboDeviceAntennaPower3.getSelectedItem().toString());
		power[3] = Integer.parseInt(cboDeviceAntennaPower4.getSelectedItem().toString());
		power[4] = Integer.parseInt(cboDeviceAntennaPower5.getSelectedItem().toString());

		System.out.println(StringTool.byteArrayToString(antLaunch, 0, antLaunch.length));
		System.out.println(StringTool.byteArrayToString(antRecieve, 0, antRecieve.length));

		byte TxChannel = (byte) (antLaunch[0] | antLaunch[1] << 1 | antLaunch[2] << 2 | antLaunch[3] << 3);
		System.out.println(TxChannel);

		byte RxChannel = (byte) (antRecieve[0] & antRecieve[1] << 1 & antRecieve[2] << 2 & antRecieve[3] << 3);
		System.out.println(RxChannel);

		for (int i = 0; i < dwellTime.length; i++) {
			if (dwellTime[i] < 0 || dwellTime[i] > 360) {
				Message.Show(rs.getString("MsgFindcardpostionvalidvalues"), "");// "相位有效值为0－180");
				return;
			}
		}
		for (int i = 0; i < power.length; i++) {
			if (power[i] < 0 || power[i] > 33) {
				Message.Show(rs.getString("MsgValidvalues"), "");// "功率有效值为0－33");
				return;
			}
		}
		try {
			for (int i = 0; i < RFIDUtil.mReaderHelper.length && null != RFIDUtil.mReaderHelper[i]; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					isConn = true;
					int result = -1;
					int result1 = -1;
					if ((RFIDUtil.mReaderHelper[i]) instanceof ImpinjRFIDReaderHelper) {
						result = (RFIDUtil.mReaderHelper[i]).setAntParamPower(antLaunch, power);
						result1 = 0;
					} else {
						result1 = ((MRFIDReaderHelper) (RFIDUtil.mReaderHelper[i])).setTxChannel((byte) 0xff,
								(byte) TxChannel);
						result = ((MRFIDReaderHelper) (RFIDUtil.mReaderHelper[i])).setCHPower((byte) 0xff,
								(byte) power[0], (byte) power[1], (byte) power[2], (byte) power[3]);
					}
					if ((int) RxChannel != 0) {
						((MRFIDReaderHelper) (RFIDUtil.mReaderHelper[i])).setRxChannel((byte) 0xff, (byte) mode,
								RxChannel);
					}
					if (result == 0 && result1 == 0) {
						isConn = true;
						labelShowInfo.setText(rs.getString("MsgSetantennaparamsucces"));// "设置天线参数成功";
						return;
					} else {
						labelShowInfo.setText(rs.getString("MsgSetantennaparamfailure"));// "设置天线参数失败";
						return;
					}
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
		} catch (Exception e) {
			Message.Show(rs.getString("MsgExSetAnt"), "");
		}

	}

	/**
	 * <p>
	 * Title: readAntParam
	 * </p>
	 * <p>
	 * Description: 读取天线设置
	 * </p>
	 */
	public static void readAntParam() {
		if (isContinueReadCard) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		}
		labelShowInfo.setText("");
		boolean isConn = false;
		try {
			for (int i = 0; i < RFIDUtil.mReaderHelper.length && null != RFIDUtil.mReaderHelper[i]; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					int result = (RFIDUtil.mReaderHelper[i]).getAntParamPower();
					isConn = true;
					if (result == 0) {
						labelShowInfo.setText(rs.getString("MsgReadantennaparamsucces"));// "读取天线参数成功";
					} else {
						labelShowInfo.setText(rs.getString("MsgReadantennaparamfailure"));// "读取天线参数失败";
					}
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
		} catch (Exception e) {
			Message.Show(rs.getString("MsgExGetAnt"), "");
		}

	}

	/**
	 * <p>
	 * Title: defaultSetup
	 * </p>
	 * <p>
	 * Description: 数据库默认设置
	 * </p>
	 * 
	 * public static void defaultSetup() { PropertiesUtils props = new
	 * PropertiesUtils(System.getProperty("user.dir").replace("\\", "/")
	 * +"/db.properties"); txtDBIP.setText((String) props.getProperty("jdbc.ip"));
	 * txtDBUser.setText((String) props.getProperty("jdbc.user"));
	 * System.out.println(props.getProperty("jdbc.user"));
	 * 
	 * txtDBPass.setText((String) props.getProperty("jdbc.password"));
	 * txtDB.setText((String) props.getProperty("jdbc.db"));
	 * txtDBTable.setText((String) props.getProperty("jdbc.table"));
	 * 
	 * }
	 */
	/**
	 * <p>
	 * Title: setParameter
	 * </p>
	 * <p>
	 * Description: 设置数据库
	 * </p>
	 * 
	 * public static void setParameter() {
	 * System.out.println("jdbc:mysql://"+txtDBIP.getText()+":3306/"+
	 * txtDB.getText() +"?useSSL=false&useUnicode=true&characterEncoding=utf-8");
	 * if((Validation.StrNotNull(txtDBIP.getText()))&&(Validation.StrNotNull(txtDBUser.getText()))&&(Validation.StrNotNull(txtDBPass.getText().toString()))&&(Validation.StrNotNull(txtDBTable.getText()))&&(Validation.StrNotNull(txtDB.getText()))){
	 * 
	 * String url="jdbc:mysql://"+txtDBIP.getText()+":3306/"+ txtDB.getText()
	 * +"?useSSL=false&useUnicode=true&characterEncoding=utf-8"; PropertiesUtils
	 * props = new PropertiesUtils(System.getProperty("user.dir").replace("\\", "/")
	 * +"/db.properties"); //
	 * props.clearInfoForFile(System.getProperty("user.dir").replace("\\", "/")
	 * +"/db.properties");
	 * 
	 * props.setProperty("jdbc.url", url.replace("\\"," "));
	 * props.setProperty("jdbc.ip", txtDBIP.getText()); props.setProperty("jdbc.db",
	 * txtDB.getText());
	 * 
	 * props.setProperty("jdbc.user", txtDBUser.getText());
	 * 
	 * 
	 * props.setProperty("jdbc.password", txtDBPass.getText());
	 * props.setProperty("jdbc.table", txtDBTable.getText());
	 * BaseDao.createDatabase(txtDB.getText()); }else {
	 * Message.Show(rs.getString("MsgExnotnull"), "");
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * <p>
	 * Title: readPort
	 * </p>
	 * <p>
	 * Description: 读取频点
	 * </p>
	 */
	public static void readPort() {
		if (isContinueReadCard) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		}
		labelShowInfo.setText("");
		boolean isConn = false;
		try {
			for (int i = 0; i < RFIDUtil.mReaderHelper.length && null != RFIDUtil.mReaderHelper[i]; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					int result = (RFIDUtil.mReaderHelper[i]).getAntParamPort();
					isConn = true;
					if (result == 0) {
						labelShowInfo.setText(rs.getString("MsgReadportsucces"));// "读取频点参数成功";
					} else {
						labelShowInfo.setText(rs.getString("MsgReadportfailure"));// "读取频点参数失败";
					}
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
		} catch (Exception e) {
			Message.Show(rs.getString("MsgExGetPort"), "");
		}

	}

	/**
	 * <p>
	 * Title: setPort
	 * </p>
	 * <p>
	 * Description: 设置频点
	 * </p>
	 */
	public static void setPort() {
		if (isContinueReadCard) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		}

		labelShowInfo.setText("");
		if (rdoFCC.isSelected()) {
			Region = 1;
		} else if (rdoETSI.isSelected()) {
			Region = 2;
		} else if (rdoCHN.isSelected()) {
			Region = 3;
		}

		port[0] = Double.parseDouble(cboPortlow.getSelectedItem().toString());
		port[1] = Double.parseDouble(cboPorthigh.getSelectedItem().toString());

		System.out.println(port[0]);
		System.out.println(port[1]);

		int low = (int) ((port[0] - 865) / 0.5);
		int high = (int) ((port[1] - 865) / 0.5);
		if (port[0] > 868) {
			low = (int) ((port[0] - 902) / 0.5) + 7;
			high = (int) ((port[1] - 902) / 0.5) + 7;
		}

		if (port[0] > port[1] && Region != 0) {
			labelShowInfo.setText(rs.getString("MsgSetportregion"));
			return;
		}

		boolean isConn = false;
		try {
			for (int i = 0; i < RFIDUtil.mReaderHelper.length && null != RFIDUtil.mReaderHelper[i]; i++) {
				if (RFIDUtil.mReaderHelper[i] != null) {
					int result = (RFIDUtil.mReaderHelper[i]).setAntParamPort(Region, low, high);
					isConn = true;
					if (result == 0) {
						labelShowInfo.setText(rs.getString("MsgSetportsucces"));// "设置频点参数成功";
					} else {
						labelShowInfo.setText(rs.getString("MsgSetportfailure"));// "设置频点参数失败";
					}
				}
			}
			if (!isConn) {
				Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			}
		} catch (Exception e) {
			Message.Show(rs.getString("MsgExSetPort"), "");
		}

	}

	/**
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description: 保存设置
	 * </p>
	 */
	public static void save() {
		initproperty();
		property.clearInfoForFile(filePath);
		property.setProperty("power_1", Integer.toString(power[0]));
		property.setProperty("power_2", Integer.toString(power[1]));
		property.setProperty("power_3", Integer.toString(power[2]));
		property.setProperty("power_4", Integer.toString(power[3]));

		if ((rdoFCC.isSelected() || rdoETSI.isSelected() || rdoCHN.isSelected()) && (port[0] <= port[1])
				&& RFIDUtil.isConn) {
			property.setProperty("region", String.valueOf(Region));
			property.setProperty("region_low", Double.toString(port[0]));
			property.setProperty("region_high", Double.toString(port[1]));
		}

	}

	/**
	 * <p>
	 * Title: initproperty
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	private static void initproperty() {
		if (property == null) {
			file = new File(filePath);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			property = new PropertiesUtils(filePath);

		}
	}

	/**
	 * <p>
	 * Title: read
	 * </p>
	 * <p>
	 * Description: 读取设置
	 * </p>
	 */
	public static void read() {
		initproperty();
		if (property.getProperty("region") != null) {
			Region = Integer.valueOf((String) property.getProperty("region"));
			port[0] = Double.valueOf((String) property.getProperty("region_low"));
			port[1] = Double.valueOf((String) property.getProperty("region_high"));
			switch (Region) {
			case 0x01:
				rdoFCC.setEnabled(true);
				break;
			case 0x02:
				rdoFCC.setEnabled(true);
				break;
			case 0x03:
				rdoFCC.setEnabled(true);
				break;
			}
			cboPortlow.setSelectedItem(port[0]);
			cboPortlow.setSelectedItem(port[1]);

		}
		if (!RFIDUtil.isConn) {
			Message.Show(rs.getString("MsgExNodevicetoconnect"), "");
			return;
		}
		if (isContinueReadCard) {
			Message.Show(rs.getString("MsgExNodevicebtnStartEnable"), "");
			return;
		} else {
			readAntParam();
			readPort();
			// defaultSetup();
		}

	}

	/**
	 * <p>
	 * Title: readData
	 * </p>
	 * <p>
	 * Description: 读取标签内信息
	 * </p>
	 */
	public static void readData() {
		RFIDUtil.isData = true;
		RFIDUtil.mode = 1;
		BasicOperate.inventoryOnce();
	}

	/**
	 * <p>
	 * Title: setData
	 * </p>
	 * <p>
	 * Description: 设置标签信息
	 * </p>
	 */
	public static void setData() {
		RFIDUtil.isData = true;
		RFIDUtil.mode = 2;
		init();
		BasicOperate.inventoryOnce();
	}

	public static void init() {
		// 判断属性
		Category category = new Category();
		System.out.println("实例化数据");
		if (Validation.StrNotNull(txtType.getText())) {
			if (Validation.checkChinese(txtType.getText())) {
				category.setCtype((txtType.getText()));
			} else {
				Message.Show(rs.getString("MsgExerrorexpression"), "");
				return;
			}
		} else {
			Message.Show(rs.getString("MsgExnotnull"), "");
//			System.out.println(7);
			return;
		}
		// 判断材质
		if (Validation.StrNotNull(txtMaterial.getText())) {
			if (Validation.checkChinese(txtMaterial.getText())) {
				category.setCmaterial((txtMaterial.getText()));
			} else {
				Message.Show(rs.getString("MsgExerrorexpression"), "");
				return;
			}
		} else {
			Message.Show(rs.getString("MsgExnotnull"), "");
//			System.out.println(7);
			return;
		}
		//

		// 判断长
		if (Validation.StrNotNull(txtLength.getText())) {
			if (Validation.isInteger(txtWidth.getText()) && Validation.isINTEGER_NEGATIVE(txtWidth.getText())) {
				category.setClength(new Integer(txtLength.getText()));
			} else {
				Message.Show(rs.getString("MsgExerrorexpression"), "");
				return;
			}
		} else {
			Message.Show(rs.getString("MsgExnotnull"), "");
//			System.out.println(7);
			return;
		}
		//
		// 判断宽
		if (Validation.StrNotNull(txtWidth.getText())) {
			if (Validation.isInteger(txtWidth.getText()) && Validation.isINTEGER_NEGATIVE(txtWidth.getText())) {
				category.setCwidth(new Integer(txtWidth.getText()));
			} else {
				Message.Show(rs.getString("MsgExerrorexpression"), "");
				return;
			}
		} else {
			Message.Show(rs.getString("MsgExnotnull"), "");
//			System.out.println(7);
			return;
		}
		//
		// 判断高
		if (Validation.StrNotNull(txtHight.getText())) {
			if (Validation.isInteger(txtHight.getText()) && Validation.isINTEGER_NEGATIVE(txtHight.getText())) {
				category.setChigh(Integer.parseInt(txtHight.getText()));
			} else {
				Message.Show(rs.getString("MsgExerrorexpression"), "");
				return;
			}
		} else {
			Message.Show(rs.getString("MsgExnotnull"), "");
//			System.out.println(7);
			return;
		}
		//
		DataEntryCloud.setCategory(category);
	}

}