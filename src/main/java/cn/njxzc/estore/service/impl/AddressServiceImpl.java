package cn.njxzc.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.njxzc.estore.dao.IAddressDao;
import cn.njxzc.estore.entity.Address;
import cn.njxzc.estore.service.IAddressService;

@Service(value = "addressService")
@Transactional
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private IAddressDao addressDao;

	@Override
	public List<Address> getAddresses(Long userId) {
		// TODO Auto-generated method stub
		return addressDao.getAddresses(userId);
	}

    @Override
    public boolean addNewAddress(Address address) {
        // TODO Auto-generated method stub
        try {
            addressDao.addNewAddress(address);
            if (address.getIsDefault() == 1) {
                // 更新默认地址
                int id = address.getId();
                addressDao.updateDefault(id);
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {
        // TODO Auto-generated method stub
        try {
            addressDao.deleteAddress(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean updateAddress(Address address) {
        // TODO Auto-generated method stub
        try {
            addressDao.updateAddress(address);
            if (address.getIsDefault() == 1) {
                addressDao.updateDefault(address.getId());
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean updateDefault(int id) {
        // TODO Auto-generated method stub
        try {
            addressDao.updateDefault(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

}
