package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import cn.njxzc.estore.entity.ItemDetail;

public interface IItemDetailDao {
	
	/**
	 * 查询某一个商品详情信息
	 * 
	 * @param id
	 */
	@Select(value = "select * from tb_item_detail where id = #{id}")
	public ItemDetail findById(long id);
	
	/**
	 * 更新商品的库存
	 * 
	 * @param id
	 */
	@Update(value = "update tb_item_detail set limit_num = #{limitNum} where id = #{id}")
	public void updateLimitNum(int limitNum, long id);
	
	/**
	 * 新增商品详细信息
	 * 
	 * @param detail
	 */
	@Insert(value = "insert into tb_item_detail(id, limit_num, version, publish_date, page_num, pack_style, small_pic_url, detail_pic_url)"
			+ "values (#{id}, #{limitNum}, #{version}, #{publishDate}, #{pageNum}, #{packStyle}, #{smallPicUrl}, #{detailPicUrl})")
	public void save(ItemDetail detail);
	
	/**
	 * 删除接口
	 * 
	 * @param id
	 */
	@Delete(value = "delete from tb_item_detail where id = #{id}")
	public void deleteDetail(long id);

}
