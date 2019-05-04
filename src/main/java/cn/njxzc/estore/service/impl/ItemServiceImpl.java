package cn.njxzc.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.njxzc.estore.dao.IItemDao;
import cn.njxzc.estore.dao.IItemDetailDao;
import cn.njxzc.estore.entity.Item;
import cn.njxzc.estore.entity.ItemDetail;
import cn.njxzc.estore.service.IItemService;

@Service(value = "itemService")
@Transactional
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private IItemDao itemDao;
	
	@Autowired
	private IItemDetailDao itemDetailDao;
	
	@Override
	public List<Item> findItems() {
		// TODO Auto-generated method stub
		return itemDao.findAll();
	}
	
	@Override
	public List<Item> findHotItems() {
		// TODO Auto-generated method stub
		return itemDao.findHotItems();
	}

	@Override
	public ItemDetail findDetailById(long id) {
		// TODO Auto-generated method stub
		return itemDetailDao.findById(id);
	}

	@Override
	public Item findItemById(long id) {
		// TODO Auto-generated method stub
		return itemDao.findItemById(id);
	}

	@Override
	public Page<Item> findAllByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		return itemDao.findAllByPage();
	}

	@Override
	public boolean updateHotRate(Long id) {
		// TODO Auto-generated method stub
		try {
			itemDao.updateHotRate(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

    @Override
    public Page<Item> findAllByPriceDesc(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNo, pageSize);
        return itemDao.findItemByPriceDesc();
    }

    @Override
    public Page<Item> findAllByPriceAsc(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNo, pageSize);
        return itemDao.findItemByPriceAsc();
    }

    @Override
    public Page<Item> findAllByPrice(int pageNo, int pageSize, int low, int high) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNo, pageSize);
        if (low > high) {
            low ^= high;
            high ^= low;
            low ^= high;
        }
        return itemDao.findItemByPrice(low, high);
    }

	@Override
	public Page<Item> searchItem(int pageNo, int pageSize, String keyword) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		return itemDao.searchItem("%" + keyword + "%");
	}

	@Override
	public boolean saveInfo(Item item) {
		// TODO Auto-generated method stub
		try {
			itemDao.save(item);
			itemDetailDao.save(item.getItemDetail());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Page<Item> findAllItems(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		return itemDao.findAllItems();
	}

	@Override
	public boolean updateStatus(long id) {
		// TODO Auto-generated method stub
		try {
			itemDao.updateStatus(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean updateNumAndPrice(long id, double price, int limitNum) {
		// TODO Auto-generated method stub
		try {
			itemDao.updatePrice(price, id);
			itemDetailDao.updateLimitNum(limitNum, id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteItem(long id) {
		// TODO Auto-generated method stub
		try {
			itemDao.deleteItem(id);
			itemDetailDao.deleteDetail(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
