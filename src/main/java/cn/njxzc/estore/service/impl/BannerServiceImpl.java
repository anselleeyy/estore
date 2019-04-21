package cn.njxzc.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.njxzc.estore.dao.IBannerDao;
import cn.njxzc.estore.dao.INavDao;
import cn.njxzc.estore.entity.Banner;
import cn.njxzc.estore.entity.Nav;
import cn.njxzc.estore.service.IBannerService;

@Service(value = "bannerService")
public class BannerServiceImpl implements IBannerService {
	
	@Autowired
	private IBannerDao bannerDao;
	
	@Autowired
	private INavDao navDao;

	@Override
	public List<Banner> findBanners() {
		// TODO Auto-generated method stub
		return bannerDao.findAll();
	}

	@Override
	public List<Nav> findNavs() {
		// TODO Auto-generated method stub
		return navDao.findAllNavs();
	}

}
