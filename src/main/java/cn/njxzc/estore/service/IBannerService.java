package cn.njxzc.estore.service;

import java.util.List;

import cn.njxzc.estore.entity.Banner;
import cn.njxzc.estore.entity.Nav;

public interface IBannerService {

	/**
	 * 查找首页 5 张轮播图信息
	 * 
	 * @return
	 */
	public List<Banner> findBanners();

	/**
	 * 查询导航栏内容
	 * 
	 * @return
	 */
	public List<Nav> findNavs();

}
