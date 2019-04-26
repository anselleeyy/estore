package cn.njxzc.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.njxzc.estore.entity.Cart;
import cn.njxzc.estore.service.ICartService;

@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping(value = "/test")
	public Object find() {
		return "SUCCESS";
	}
	
	@GetMapping(value = "/{userId}")
	public Object findCarts(@PathVariable Long userId) {
		return cartService.findAllCarts(userId);
	}
	
	/**
	 * 删除某一条商品记录
	 */
	@DeleteMapping(value = "/{id}")
	public Object deleteItem(@PathVariable int id) {
		return cartService.delete(id);
		
	}
	
	@PutMapping(value = "/{id}/{num}")
	public Object updateNum(@PathVariable int id, @PathVariable int num) {
        return cartService.updateNum(num, id);
	}
	
	@PutMapping(value = "/order/{userId}")
	public Object orderCart(@PathVariable Long userId) {
		return cartService.orderCart(userId);
	}
	
	@PostMapping(value = "/add")
	public Object addCart(@RequestBody Cart cart) {
		System.out.println(cart);
//		return "SUCCESS";
		return cartService.insertCart(cart);
	}

}
