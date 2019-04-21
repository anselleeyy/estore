package cn.njxzc.estore.entity;

import java.io.Serializable;
import java.util.Date;

public class Nav implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 820935240434401938L;

	private int id;
	
	private String navName;
	
	private String navUrl;
	
	private int sort;
	
	private Date created;
	
	private Date updated;

	public Nav() {
		super();
	}

	public Nav(int id, String navName, String navUrl, int sort, Date created, Date updated) {
		super();
		this.id = id;
		this.navName = navName;
		this.navUrl = navUrl;
		this.sort = sort;
		this.created = created;
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getNavUrl() {
		return navUrl;
	}

	public void setNavUrl(String navUrl) {
		this.navUrl = navUrl;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Nav [id=" + id + ", navName=" + navName + ", navUrl=" + navUrl + ", sort=" + sort + ", created="
				+ created + ", updated=" + updated + "]";
	}

}
