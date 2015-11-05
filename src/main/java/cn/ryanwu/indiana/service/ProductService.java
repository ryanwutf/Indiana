package cn.ryanwu.indiana.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ryanwu.indiana.common.Page;
import cn.ryanwu.indiana.common.ResponseData;
import cn.ryanwu.indiana.config.Constants;
import cn.ryanwu.indiana.dao.ProductDao;
import cn.ryanwu.indiana.model.Product;
import cn.ryanwu.indiana.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public List<ProductVo> listEnabledByPage(Page<Product> page) {
		
		List<Product> products =  productDao.listEabledByPage(page);
		List<ProductVo> productVos = new ArrayList<>();
		products.stream().forEach((product) -> {
			try {
				product.setImage(Constants.IMAGE_URL_PREFIX + product.getImage());
				ProductVo vo = new ProductVo();
				BeanUtils.copyProperties(vo, product);
				vo.setProgress(50);
				productVos.add(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return productVos;
	}

}
