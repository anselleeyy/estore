package cn.njxzc.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.njxzc.estore.entity.Order;
import cn.njxzc.estore.service.IOrderService;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/order")
@Api(tags = { "Order" })
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping(value = "/create")
	public Object createOrder(@RequestBody Order order) {
		Response response = null;
		boolean flag = orderService.createOrder(order);
		if (flag) {
			response = new Response(ReturnCode.ORDER_CREATE_SUCCEED);
		} else {
			response = new Response(ReturnCode.ORDER_CREATE_FAILED);
		}
		return response;
	}
	
	@GetMapping(value = "/{userId}")
	public Object getOrder(@RequestParam int currentPage, @RequestParam int pageSize, @PathVariable Long userId) {
		List<Order> orders = orderService.findByUserId(currentPage, pageSize, userId);
		PageInfo<Order> page = new PageInfo<>(orders);
		Response response = new Response(ReturnCode.ORDER_LIST_GOT, page);
		return response;
	}
	
	@GetMapping(value = "/page")
	public Object getAllOrders(@RequestParam int currentPage, @RequestParam int pageSize) {
		List<Order> orders = orderService.findAllByPage(currentPage, pageSize);
		PageInfo<Order> page = new PageInfo<>(orders);
		Response response = new Response(ReturnCode.ORDER_LIST_GOT, page);
		return response;
	}

}
