/**  
* <p>Title: TagRecordDao.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019年7月29日  
* @version 1.0  
*/
package com.rfid.dao;

import com.rfid.entity.TagRecord;

/**
 * <p>
 * Title: TagRecordDao
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019年7月29日
 */
public interface TagRecordDao {
	int insert(TagRecord tagRecord);
}
