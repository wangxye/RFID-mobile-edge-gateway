/**  
* <p>Title: R2kUtil.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date 2019年7月27日  
* @version 1.0  
*/
package com.rfid.main.tool;

import com.rfid.main.util.ZLDMHandler;
import com.rfid.service.RFIDOperation;

/**
 * <p>
 * Title: RFIDUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019年7月27日
 */
public class RFIDUtil {

	/**
	 * 读写器连接情况
	 */
	public static boolean isConn = false;
	/**
	 * 限制连接设备数量
	 */
	public final static int MAX_DEVICE_NUM = 50;
	/**
	 * 获取网络IP的_卓岚动态库dll文件
	 */
	public static ZLDMHandler secondhandler = new ZLDMHandler();
	/**
	 * 连接对象数组R2K
	 */
	public final static RFIDOperation[] mReaderHelper = new RFIDOperation[MAX_DEVICE_NUM];
	/**
	 * 读取对象数据
	 */
	public static boolean isData = false;
	/**
	 * 读取模式：1 录入模式：2 其他模式：0
	 */
	public static int mode = 0;
	/**
	 * 是否停止读取
	 */
	public static boolean isStop = false;
	/**
	 * 是否为持续寻卡
	 */
	public static boolean isContinue = false;

}
