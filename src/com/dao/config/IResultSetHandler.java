/**  
* <p>Title: IResultSetHandler.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020��2��4��  
* @version 1.0  
*/
package com.dao.config;

import java.sql.ResultSet;

/**
 * <p>
 * Title: IResultSetHandler
 * </p>
 * <p>
 * Description: ��JDBC���صĽ������װ���ض�����
 * </p>
 * 
 * @author wangxuanye
 * @date 2020��2��4��
 */
public interface IResultSetHandler<T> {

	T handle(ResultSet rs) throws Exception;
}
