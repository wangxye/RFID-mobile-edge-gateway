/**  
* <p>Title: Category.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2020年7月6日  
* @version 1.0  
*/
package com.rfid.entity;

/**
 * <p>
 * Title: Category
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2020年7月6日
 */
public class Category {

	/**
	 * 标签卡号
	 */
	private String ctag_id;
	/**
	 * 对象类型
	 */
	private String ctype;
	/**
	 * 对象材料
	 */
	private String cmaterial;
	/**
	 * 对象长度
	 */
	private Integer clength;
	/**
	 * 对象宽度
	 */
	private Integer cwidth;
	/**
	 * 对象高度
	 */
	private Integer chigh;

	/**
	 * @return the ctag_id
	 */
	public String getCtag_id() {
		return ctag_id;
	}

	/**
	 * @param ctag_id the ctag_id to set
	 */
	public void setCtag_id(String ctag_id) {
		this.ctag_id = ctag_id;
	}

	/**
	 * @return the ctype
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	 * @param ctype the ctype to set
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	/**
	 * @return the cmaterial
	 */
	public String getCmaterial() {
		return cmaterial;
	}

	/**
	 * @param cmaterial the cmaterial to set
	 */
	public void setCmaterial(String cmaterial) {
		this.cmaterial = cmaterial;
	}

	/**
	 * @return the clength
	 */
	public Integer getClength() {
		return clength;
	}

	/**
	 * @param clength the clength to set
	 */
	public void setClength(Integer clength) {
		this.clength = clength;
	}

	/**
	 * @return the cwidth
	 */
	public Integer getCwidth() {
		return cwidth;
	}

	/**
	 * @param cwidth the cwidth to set
	 */
	public void setCwidth(Integer cwidth) {
		this.cwidth = cwidth;
	}

	/**
	 * @return the chigh
	 */
	public Integer getChigh() {
		return chigh;
	}

	/**
	 * @param chigh the chigh to set
	 */
	public void setChigh(Integer chigh) {
		this.chigh = chigh;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: hashCode</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chigh == null) ? 0 : chigh.hashCode());
		result = prime * result + ((clength == null) ? 0 : clength.hashCode());
		result = prime * result + ((cmaterial == null) ? 0 : cmaterial.hashCode());
		result = prime * result + ((ctag_id == null) ? 0 : ctag_id.hashCode());
		result = prime * result + ((ctype == null) ? 0 : ctype.hashCode());
		result = prime * result + ((cwidth == null) ? 0 : cwidth.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: equals</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @param obj
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (chigh == null) {
			if (other.chigh != null)
				return false;
		} else if (!chigh.equals(other.chigh))
			return false;
		if (clength == null) {
			if (other.clength != null)
				return false;
		} else if (!clength.equals(other.clength))
			return false;
		if (cmaterial == null) {
			if (other.cmaterial != null)
				return false;
		} else if (!cmaterial.equals(other.cmaterial))
			return false;
		if (ctag_id == null) {
			if (other.ctag_id != null)
				return false;
		} else if (!ctag_id.equals(other.ctag_id))
			return false;
		if (ctype == null) {
			if (other.ctype != null)
				return false;
		} else if (!ctype.equals(other.ctype))
			return false;
		if (cwidth == null) {
			if (other.cwidth != null)
				return false;
		} else if (!cwidth.equals(other.cwidth))
			return false;
		return true;
	}

}
