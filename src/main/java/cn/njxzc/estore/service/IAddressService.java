package cn.njxzc.estore.service;

import java.util.List;

import cn.njxzc.estore.entity.Address;

public interface IAddressService {

    /**
     * 根据 userId 查询用户的所有收货地址
     * 
     * @param userId
     * @return
     */
    public List<Address> getAddresses(Long userId);

    /**
     * 新增一个收货地址信息
     * 
     * @param address
     */
    public boolean addNewAddress(Address address);

    /**
     * 删除用户的一条收货地址记录 不是真的删除，通过标记来判断
     * 注意这里不允许删除默认地址，交由前端判断
     * 
     * @param address
     */
    public boolean deleteAddress(int id);

    /**
     * 根据 id 更新数据库信息
     * 
     * @param address
     */
    public boolean updateAddress(Address address);

    /**
     * 更新默认地址
     * 
     * @param id
     */
    public boolean updateDefault(int id);

}
