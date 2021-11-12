/**  
* <p>Title: RFIDOperation.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年4月28日  
* @version 1.0  
*/
package com.rfid.service;

/**
 * <p>
 * Title: RFIDOperation
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年4月28日
 */
public interface RFIDOperation {

	public void connect();

	public Integer disconnect();

	public Integer startReader(byte btRepeat);

	public Integer inventoryOnce();

	public Integer stopReadCard();

	public Integer setAntParamPower(byte[] Ant, int[] power);

	public Integer getAntParamPower();

	public Integer setAntParamPort(int Region, int port_low, int port_high);

	public Integer getAntParamPort();

}
