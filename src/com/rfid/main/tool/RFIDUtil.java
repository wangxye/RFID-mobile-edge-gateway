/**  
* <p>Title: R2kUtil.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date 2019��7��27��  
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
 * @date 2019��7��27��
 */
public class RFIDUtil {

	/**
	 * ��д���������
	 */
	public static boolean isConn = false;
	/**
	 * ���������豸����
	 */
	public final static int MAX_DEVICE_NUM = 50;
	/**
	 * ��ȡ����IP��_׿ᰶ�̬��dll�ļ�
	 */
	public static ZLDMHandler secondhandler = new ZLDMHandler();
	/**
	 * ���Ӷ�������R2K
	 */
	public final static RFIDOperation[] mReaderHelper = new RFIDOperation[MAX_DEVICE_NUM];
	/**
	 * ��ȡ��������
	 */
	public static boolean isData = false;
	/**
	 * ��ȡģʽ��1 ¼��ģʽ��2 ����ģʽ��0
	 */
	public static int mode = 0;
	/**
	 * �Ƿ�ֹͣ��ȡ
	 */
	public static boolean isStop = false;
	/**
	 * �Ƿ�Ϊ����Ѱ��
	 */
	public static boolean isContinue = false;

}
