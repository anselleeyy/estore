package cn.njxzc.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.njxzc.estore.dao.IAddressDao;
import cn.njxzc.estore.entity.Address;
import cn.njxzc.estore.service.IAddressService;

@Service(value = "addressService")
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private IAddressDao addressDao;

	@Override
	public List<Address> getAddresses(Long userId) {
		// TODO Auto-generated method stub
		return addressDao.getAddresses(userId);
	}

}
