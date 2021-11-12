/**  
* <p>Title: IResultSetHandler.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年2月4日  
* @version 1.0  
*/
package com.dao.config;

import java.sql.ResultSet;

/**
 * <p>
 * Title: IResultSetHandler
 * </p>
 * <p>
 * Description: 把JDBC返回的结果集封装成特定类型
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年2月4日
 */
public interface IResultSetHandler<T> {

	T handle(ResultSet rs) throws Exception;
}
