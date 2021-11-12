/**  
* <p>Title: CategoryDao.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年7月6日  
* @version 1.0  
*/
package com.rfid.dao;

import com.rfid.entity.Category;

/**
 * <p>
 * Title: CategoryDao
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年7月6日
 */
public interface CategoryDao {

	/**
	 * 
	 * <p>
	 * Title: insert
	 * </p>
	 * <p>
	 * Description: 添加货物信息
	 * </p>
	 * 
	 * @param category
	 * @return
	 */
	int insert(Category category);

	/**
	 * 
	 * <p>
	 * Title: selectonebyTagid
	 * </p>
	 * <p>
	 * Description: 根据tag_id查询用户
	 * </p>
	 * 
	 * @param tag_id
	 * @return
	 */
	Category selectonebyTagid(String tag_id);

	/**
	 * 
	 * <p>
	 * Title: updateAll
	 * </p>
	 * <p>
	 * Description: 更新用户信息
	 * </p>
	 * 
	 * @param category
	 * @return
	 */
	int updateAll(Category category);
}
