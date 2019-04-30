package cn.njxzc.estore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.njxzc.estore.entity.Cart;
import cn.njxzc.estore.service.ICartService;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;

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
	    List<Cart> list = cartService.findAllCarts(userId);
	    Response response = new Response(ReturnCode.CART_LIST_GOT, list);
		return response;
	}
	
    /**
     * 删除某一条商品记录
     * 
     * @param userId
     * @param itemId
     * @return
     */
	@DeleteMapping(value = "/delete")
	public Object deleteItem(@RequestParam long itemId, @RequestParam long userId) {
	    Response response = null;
		boolean flag = cartService.delete(userId, itemId);
		if (flag) {
            response = new Response(ReturnCode.CART_DELETE_SUCCEED);
        } else {
            response = new Response(ReturnCode.CART_DELETE_FAILED);
        }
        return response;
	}
	
    @PutMapping(value = "/update")
    public Object updateNum(@RequestBody Cart cart) {
        Response response = null;
        int num = cart.getNumber();
        Long itemId = cart.getItemId();
        Long userId = cart.getUserId();
        boolean flag = cartService.updateNum(num, itemId, userId);
        if (flag) {
            response = new Response(ReturnCode.CART_UPDATE_SUCCEED);
        } else {
            response = new Response(ReturnCode.CART_UPDATE_FAILED);
        }
        return response;
    }
	
	@PutMapping(value = "/order/{userId}")
	public Object orderCart(@PathVariable Long userId) {
		return cartService.orderCart(userId);
	}
	
	@PostMapping(value = "/add")
	public Object addCart(@RequestBody Cart cart) {
		Response response = null;
		List<Cart> list = new ArrayList<>();
		list.add(cart);
        boolean flag = cartService.insertCart(list);
        if (flag) {
            response = new Response(ReturnCode.CART_ADD_SUCCEED);
        } else {
            response = new Response(ReturnCode.CART_ADD_FAILED);
        }
        return response;
	}
	
	@PostMapping(value = "/push")
	public Object mergeAll(@RequestBody List<Cart> cartList) {
	    Response response = null;
	    boolean flag = cartService.insertCart(cartList);
	    if (flag) {
            response = new Response(ReturnCode.CART_ADD_SUCCEED);
        } else {
            response = new Response(ReturnCode.CART_ADD_FAILED);
        }
	    return response;
	}

}
