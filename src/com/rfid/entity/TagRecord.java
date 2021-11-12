/**  
* <p>Title: TagRecord.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019��7��29��  
* @version 1.0  
*/
package com.rfid.entity;

/**
 * <p>
 * Title: TagRecord
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019��7��29��
 */
public class TagRecord {
	/**
	 * ���
	 */
	private byte id;
	/**
	 * ����
	 */
	private String EPC;
	/**
	 * ����ʱ��
	 */
	private String createDate;
	/**
	 * ��ȡ���ߺ�
	 */
	private byte antNo;
	/**
	 * ��ȡRSSI
	 */
	private String Rssi;
	/**
	 * �豸��
	 */
	private String host;
	/**
	 * ��ǩ����Typeֵ
	 */
	private String Type;
	/**
	 * Status
	 */
	private int Statu = 1;

	/**
	 * @return the id
	 */
	public byte getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(byte id) {
		this.id = id;
	}

	/**
	 * @return the antId
	 */
	public String getEPC() {
		return EPC;
	}

	/**
	 * @param antId the antId to set
	 */
	public void setEPC(String epc) {
		EPC = epc;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the antNo
	 */
	public byte getAntNo() {
		return antNo;
	}

	/**
	 * @param antNo the antNo to set
	 */
	public void setAntNo(byte antNo) {
		this.antNo = antNo;
	}

	/**
	 * @return the rssi
	 */
	public String getRssi() {
		return Rssi;
	}

	/**
	 * @param rssi the rssi to set
	 */
	public void setRssi(String rssi) {
		Rssi = rssi;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		Type = "";
		Type += EPC.charAt(0);
		return Type;
	}

	/**
	 * @return the statu
	 */
	public int getStatu() {
		return Statu;
	}

	/**
	 * @param statu the statu to set
	 */
	public void setStatu(int statu) {
		Statu = statu;
	}

}
