package cn.ryanwu.indiana.dao;

import org.crazycake.jdbcTemplateTool.JdbcTemplateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected JdbcTemplate jdbc;
	@Autowired
	protected JdbcTemplateTool jdbcTool;
	
	
}
