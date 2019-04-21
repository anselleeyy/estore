package cn.njxzc.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.njxzc.estore.entity.Banner;
import cn.njxzc.estore.entity.Nav;
import cn.njxzc.estore.service.IBannerService;

@RestController
@CrossOrigin
@RequestMapping(value = "item")
public class BannerController {

    @Autowired
    private IBannerService bannerService;

    @GetMapping(value = "/banner")
    public Object findBanners() {
        List<Banner> banners = bannerService.findBanners();
        return banners;
    }

    @GetMapping(value = "/nav")
    public Object findNavs() {
        List<Nav> navs = bannerService.findNavs();
        return navs;
    }

}
