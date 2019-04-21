package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.Nav;

public interface INavDao {
	
	/**
	 * 查询返回导航栏内容
	 * @return
	 */
	@Select(value = "select * from tb_nav order by sort asc")
	public List<Nav> findAllNavs();

}
