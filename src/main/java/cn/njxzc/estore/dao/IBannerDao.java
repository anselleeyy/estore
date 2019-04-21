package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.Banner;

public interface IBannerDao {
	
	@Select(value = "select * from tb_banner order by sort_order asc")
	public List<Banner> findAll();

}
