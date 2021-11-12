/**  
* <p>Title: CategoryDaoimpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年7月6日  
* @version 1.0  
*/
package com.rfid.dao.impl;

import com.dao.config.impl.BeanHandler;
import com.rfid.dao.BaseDao;
import com.rfid.dao.CategoryDao;
import com.rfid.entity.Category;

/**
 * <p>
 * Title: CategoryDaoimpl
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年7月6日
 */
public class CategoryDaoimpl extends BaseDao implements CategoryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: insert</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param category
	 * 
	 * @return
	 * 
	 * @see com.rfid.dao.CategoryDao#insert(com.rfid.entity.Category)
	 * 
	 */
	@Override
	public int insert(Category category) {
		String sql = "insert into " + datatable + " values(?,?,?,?,?,?)";
		return this.ExecuteNonQuery(sql, category.getCtag_id(), category.getCtype(), category.getCmaterial(),
				category.getClength(), category.getCwidth(), category.getChigh());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: selectonebyTagid</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param tag_id
	 * 
	 * @return
	 * 
	 * @see com.rfid.dao.CategoryDao#selectonebyTagid(java.lang.String)
	 * 
	 */
	@Override
	public Category selectonebyTagid(String tag_id) {
		String sql = "select * from " + datatable + " where ctag_id = ?";
		return this.executeQuery(sql, new BeanHandler<>(Category.class), tag_id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: updateAll</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param category
	 * 
	 * @return
	 * 
	 * @see com.rfid.dao.CategoryDao#updateAll(com.rfid.entity.Category)
	 * 
	 */
	@Override
	public int updateAll(Category category) {
		String sql = "update " + datatable
				+ " set ctype = ?,cmaterial = ?, clength = ?, cwidth = ?, chigh = ? where ctag_id = ?";
		return this.ExecuteNonQuery(sql, category.getCtype(), category.getCmaterial(), category.getClength(),
				category.getCwidth(), category.getChigh(), category.getCtag_id());
	}

}
