package cn.njxzc.estore.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.njxzc.estore.dao.ICartDao;
import cn.njxzc.estore.dao.IOrderDao;
import cn.njxzc.estore.dao.IOrderDetailDao;
import cn.njxzc.estore.entity.Order;
import cn.njxzc.estore.entity.OrderDetail;
import cn.njxzc.estore.service.IOrderService;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderDao orderDao;
	
	@Autowired
	private IOrderDetailDao orderDetailDao;
	
	@Autowired
	private ICartDao cartDao;

	private static AtomicInteger serialNumber = new AtomicInteger(0);

	@Override
	@Transactional
	public boolean createOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			String orderId = generateOrderId();
			order.setOrderId(orderId);
			// 创建订单
			orderDao.createOrder(order);
			for (OrderDetail detail : order.getDetails()) {
				detail.setOrderId(orderId);
				// 订单详细
				orderDetailDao.addDetail(detail);
			}
			// 更新购物车标记位
			cartDao.orderCart(order.getUserId());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Order> findByUserId(int pageNo, int pageSize, Long userId) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		Page<Order> orders = orderDao.findByUserId(userId);
		orders.getResult().stream().forEach(order -> {
			order.setDetails(orderDetailDao.findByOrderId(order.getOrderId()));
		});
		return orders;
	}

	@Override
	public Page<Order> findAllByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		Page<Order> orders = orderDao.findAllByPage();
		orders.getResult().stream().forEach(order -> {
			order.setDetails(orderDetailDao.findByOrderId(order.getOrderId()));
		});
		return orders;
	}
	
	/**
	 * 订单 id 生成器
	 * 生成规则：毫秒级别时间戳+3位流水号
	 * 利用 LocalDateTime 和 AtomicInteger 保证线程安全
	 * 
	 * @return
	 */
	private String generateOrderId() {
		// 利用 jdk8 LocalDateTime 保证线程安全
		LocalDateTime now = LocalDateTime.now();
		// 根据当前时间生成13位时间戳（毫秒级别）
		long mills = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
		// 只取3位流水号，超过即重置
		if (serialNumber.get() > 999) {
			serialNumber.set(0);
		}
		String orderId = mills + String.format("%03d", serialNumber.getAndAdd(1));
		return orderId;
	}

	@Override
	public boolean updatePriceAndNum(String orderId, Integer num, Double price) {
		// TODO Auto-generated method stub
		try {
			orderDetailDao.updateInfo(orderId, num, price, num * price);
			// TODO: 更新订单的总额
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		try {
			orderDao.delete(orderId);
			orderDetailDao.deleteDetail(orderId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
