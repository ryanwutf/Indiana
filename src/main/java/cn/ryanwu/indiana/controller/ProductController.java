package cn.ryanwu.indiana.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ryanwu.indiana.common.Page;
import cn.ryanwu.indiana.common.ResponseData;
import cn.ryanwu.indiana.model.Product;
import cn.ryanwu.indiana.service.ProductService;
import cn.ryanwu.indiana.utils.ResponseUtil;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseData list(@RequestParam Integer no, @RequestParam Integer size) {
		Page<Product> page = new Page<>();
		page.setPageNo(no);
		page.setPageSize(size);
		return ResponseUtil.success(productService.listEnabledByPage(page));
	}
}
