/**  
* <p>Title: DataEntryCloud.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年7月6日  
* @version 1.0  
*/
package com.rfid.main.deviceParams;

import com.main.test.RFIDdemo;
import com.rfid.dao.CategoryDao;
import com.rfid.dao.impl.CategoryDaoimpl;
import com.rfid.entity.Category;
import com.rfid.rxobserver.bean.RXInventoryTag;

/**
 * <p>
 * Title: DataEntryCloud
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年7月6日
 */
public class DataEntryCloud extends RFIDdemo {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 224L;

	private static Category mcategory = new Category();

	private static CategoryDao categoryDao = new CategoryDaoimpl();

	/**
	 * @param category the category to set
	 */
	public static void setCategory(Category category) {
		mcategory = category;
	}

	/**
	 * 
	 * <p>
	 * Title: insertCategory
	 * </p>
	 * <p>
	 * Description: 录入
	 * </p>
	 * 
	 * @param tag
	 */
	public static void insertCategory(RXInventoryTag tag) {
		mcategory.setCtag_id(tag.strEPC);
		if (categoryDao.selectonebyTagid(mcategory.getCtag_id()) != null) {
			Category category = categoryDao.selectonebyTagid(mcategory.getCtag_id());
			if (mcategory.equals(category)) {
				// Category category = categoryDao.selectonebyTagid(mcategory.getCtag_id());
				labelShowInfo.setText(rs.getString("MsgExistCategory"));
				txtType.setText(category.getCtype());
				txtMaterial.setText(category.getCmaterial());
				txtLength.setText(Integer.toString(category.getClength()));
				txtWidth.setText(Integer.toString(category.getCwidth()));
				txtHight.setText(Integer.toString(category.getChigh()));
			} else {
				categoryDao.updateAll(mcategory);
			}
//			
//			return;
		} else {
			categoryDao.insert(mcategory);
			labelShowInfo.setText(rs.getString("MsgInsertCategorySuccess"));
		}

	}

	/**
	 * 
	 * <p>
	 * Title: showCategory
	 * </p>
	 * <p>
	 * Description: 读取
	 * </p>
	 * 
	 * @param tag
	 */
	public static void showCategory(RXInventoryTag tag) {
		mcategory.setCtag_id(tag.strEPC);
		if (categoryDao.selectonebyTagid(mcategory.getCtag_id()) != null) {
			Category category = categoryDao.selectonebyTagid(mcategory.getCtag_id());
			labelShowInfo.setText(rs.getString("MsgExistCategory"));
			txtType.setText(category.getCtype());
			txtMaterial.setText(category.getCmaterial());
			txtLength.setText(Integer.toString(category.getClength()));
			txtWidth.setText(Integer.toString(category.getCwidth()));
			txtHight.setText(Integer.toString(category.getChigh()));
//			categoryDao.updateAll(mcategory);
//			return;
		} else {
			labelShowInfo.setText(rs.getString("MsgNoExistCategory"));
		}
	}

}
