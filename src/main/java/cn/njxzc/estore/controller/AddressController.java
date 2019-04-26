package cn.njxzc.estore.controller;

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
import org.springframework.web.bind.annotation.RestController;

import cn.njxzc.estore.entity.Address;
import cn.njxzc.estore.service.IAddressService;
import cn.njxzc.estore.utils.Response;
import cn.njxzc.estore.utils.ReturnCode;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping(value = "/address")
@Api(tags = {"Address"})
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping(value = "/{userId}")
    public Object getAddressList(@PathVariable Long userId) {
        List<Address> list = addressService.getAddresses(userId);
        Response response = new Response(ReturnCode.ADDRESS_LIST_GOT, list);
        return response;
    }

    /**
     * 新增一个收货地址信息
     * 
     * @param address
     */
    @PostMapping(value = "/add")
    public Object addNewAddress(@RequestBody Address address) {
        Response response = null;
        boolean flag = addressService.addNewAddress(address);
        if (flag) {
            response = new Response(ReturnCode.ADDRESS_ADD_SUCCEED);
        } else {
            response = new Response(ReturnCode.ADDRESS_ADD_FAILED);
        }
        return response;
    }

    /**
     * 删除用户的一条收货地址记录 不是真的删除，通过标记来判断 注意这里不允许删除默认地址，交由前端判断
     * 
     * @param address
     */
    @DeleteMapping(value = "/delete/{id}")
    public Object deleteAddress(@PathVariable int id) {
        Response response = null;
        boolean flag = addressService.deleteAddress(id);
        if (flag) {
            response = new Response(ReturnCode.ADDRESS_DELETE_SUCCEED);
        } else {
            response = new Response(ReturnCode.ADDRESS_DELETE_FAILED);
        }
        return response;
    }

    /**
     * 根据 id 更新数据库信息
     * 
     * @param address
     */
    @PutMapping(value = "/update")
    public Object updateAddress(@RequestBody Address address) {
        Response response = null;
        boolean flag = addressService.updateAddress(address);
        if (flag) {
            response = new Response(ReturnCode.ADDRESS_UPDATE_SUCCEED);
        } else {
            response = new Response(ReturnCode.ADDRESS_UPDATE_FAILED);
        }
        return response;
    }

    /**
     * 更新默认地址
     * 
     * @param id
     */
    @PutMapping(value = "/update/{id}")
    public Object updateDefault(@PathVariable int id) {
        Response response = null;
        boolean flag = addressService.updateDefault(id);
        if (flag) {
            response = new Response(ReturnCode.ADDRESS_UPDATE_SUCCEED);
        } else {
            response = new Response(ReturnCode.ADDRESS_UPDATE_FAILED);
        }
        return response;
    }

}
