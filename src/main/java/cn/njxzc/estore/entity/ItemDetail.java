package cn.njxzc.estore.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.njxzc.estore.utils.Constants;

public class ItemDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1065577694482730099L;

	private long id;
	
	private int limitNum;
	
	private String version;
	
	private String publishDate;
	
	private int pageNum;
	
	private String packStyle;
	
	@JsonIgnore
	private String smallPicUrl;
	
	private String detailPicUrl;
	
	private List<String> smallPicList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getPackStyle() {
		return packStyle;
	}

	public void setPackStyle(String packStyle) {
		this.packStyle = packStyle;
	}

	public void setSmallPicUrl(String smallPicUrl) {
		this.smallPicUrl = smallPicUrl;
		smallPicList = Arrays.asList(smallPicUrl.split(","));
	}

	public String getDetailPicUrl() {
		return detailPicUrl;
	}

	public void setDetailPicUrl(String detailPicUrl) {
		this.detailPicUrl = detailPicUrl;
	}

	public List<String> getSmallPicList() {
		String[] temp = smallPicUrl.split(",");
		smallPicList = new LinkedList<>();
		for (String string : temp) {
			smallPicList.add(Constants.NGINX_URL + string.trim());
		}
		return smallPicList;
	}

	public void setSmallPicList(List<String> smallPicList) {
		this.smallPicList = Arrays.asList(smallPicUrl.split(","));
	}

	@Override
	public String toString() {
		return "ItemDetail [id=" + id + ", limitNum=" + limitNum + ", version=" + version + ", publishDate="
				+ publishDate + ", pageNum=" + pageNum + ", packStyle=" + packStyle + ", smallPicUrl=" + smallPicUrl
				+ ", detailPicUrl=" + detailPicUrl + ", smallPicList=" + smallPicList + "]";
	}

}
