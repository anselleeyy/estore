package cn.njxzc.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.njxzc.estore.entity.Address;

public interface IAddressDao {

    @Select(
        value = "select * from tb_order_address where user_id = #{userId} and is_delete = 0 order by is_default desc;")
    public List<Address> getAddresses(Long userId);

    @Insert(
        value = "insert into tb_order_address(user_id, pass_name, address, tel) values (#{userId}, #{passName}, #{address}, #{tel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int addNewAddress(Address address);

    @Update(value = "update tb_order_address set is_delete = 1 where id = #{id};")
    public void deleteAddress(int id);

    @Update(
        value = "update tb_order_address set pass_name = #{passName}, address = #{address}, tel = #{tel} where id = #{id}")
    public void updateAddress(Address address);

    @Update(value = "update tb_order_address set is_default = (case when id = #{id} then 1 else 0 END);")
    public void updateDefault(int id);

}
