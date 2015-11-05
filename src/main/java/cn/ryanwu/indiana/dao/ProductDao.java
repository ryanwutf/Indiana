package cn.ryanwu.indiana.dao;

import java.util.List;

import org.crazycake.jdbcTemplateTool.JdbcTemplateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.ryanwu.indiana.common.Page;
import cn.ryanwu.indiana.model.Product;

@Repository
public class ProductDao {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbc;
	@Autowired
	protected JdbcTemplateTool jdbcTool;
	
	public List<Product> listAll() {
		return jdbcTool.list("select * from ra_product", null, Product.class);
	}
	
	public List<Product> listEabledByPage(Page<Product> page) {
		String sql = "select * from ra_product where status = 1 order by sort_order asc limit ?,?";
		return jdbcTool.list(sql,
				new Object[] { page.getFirst(), page.getPageSize()}, Product.class);
	}
	
	
}
