package cn.njxzc.estore.service.impl;

import java.util.List;

import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.njxzc.estore.dao.ICartDao;
import cn.njxzc.estore.entity.Cart;
import cn.njxzc.estore.service.ICartService;

@Transactional
@Service(value = "cartService")
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private ICartDao cartDao;

	@Override
	public List<Cart> findAllCarts(Long userId) {
		// TODO Auto-generated method stub
		return cartDao.findAll(userId);
	}

	@Override
	public boolean delete(long userId, long itemId) {
		// TODO Auto-generated method stub
		try {
			cartDao.deleteCart(userId, itemId);
			return true;
		} catch (TransactionException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateNum(int num, int id) {
		// TODO Auto-generated method stub
		try {
			cartDao.updateNumById(num, id);
			return true;
		} catch (TransactionException e) {
			// TODO: handle exception
			return false;
		}
	}

    @Override
    public boolean updateNum(int num, long itemId, long userId) {
        // TODO Auto-generated method stub
        try {
            cartDao.updateNum(num, itemId, userId);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

	@Override
	public boolean orderCart(Long userId) {
		// TODO Auto-generated method stub
		try {
			cartDao.orderCart(userId);
			return true;
		} catch (TransactionException e) {
			// TODO: handle exception
			return false;
		}
	}

    @Override
    public boolean insertCart(List<Cart> cartList) {
        // TODO Auto-generated method stub
        try {
            for (Cart cart : cartList) {
                Cart temp = cartDao.findIfExist(cart.getUserId(), cart.getItemId());
                if (null != temp) {
                    // 存在记录就更新数量
                    cartDao.updateNumById(cart.getNumber(), temp.getId());
                } else {
                    // 不存在就直接新增
                    cartDao.insertNewRec(cart);
                }
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

}
