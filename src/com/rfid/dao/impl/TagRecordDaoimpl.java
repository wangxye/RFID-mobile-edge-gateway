/**  
* <p>Title: TagRecordimpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019年7月29日  
* @version 1.0  
*/
package com.rfid.dao.impl;

import com.rfid.dao.BaseDao;
import com.rfid.dao.TagRecordDao;
import com.rfid.entity.TagRecord;

/**
 * <p>
 * Title: TagRecordimpl
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019年7月29日
 */
public class TagRecordDaoimpl extends BaseDao implements TagRecordDao {

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: insert</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param tagRecord
	 * 
	 * @return
	 * 
	 * @see com.rfid.dao.TagRecordDao#insert(com.rfid.bean.TagRecord)
	 * 
	 */
	@Override
	public int insert(TagRecord tagRecord) {
		String sql = "insert into " + table + " values(?,now(),?,?,?,?,?)";
		return this.ExecuteNonQuery(sql, tagRecord.getEPC(), tagRecord.getAntNo(), tagRecord.getRssi(),
				tagRecord.getHost(), tagRecord.getType(), tagRecord.getStatu());
	}

}
