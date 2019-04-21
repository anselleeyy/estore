package cn.njxzc.estore.service;

import java.util.List;

import cn.njxzc.estore.entity.Address;

public interface IAddressService {
	
	public List<Address> getAddresses(Long userId);

}
