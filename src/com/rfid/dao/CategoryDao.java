/**  
* <p>Title: CategoryDao.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020��7��6��  
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
 * @date 2020��7��6��
 */
public interface CategoryDao {

	/**
	 * 
	 * <p>
	 * Title: insert
	 * </p>
	 * <p>
	 * Description: ��ӻ�����Ϣ
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
	 * Description: ����tag_id��ѯ�û�
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
	 * Description: �����û���Ϣ
	 * </p>
	 * 
	 * @param category
	 * @return
	 */
	int updateAll(Category category);
}
