package cn.ryanwu.indiana.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.crazycake.jdbcTemplateTool.JdbcTemplateTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
//@PropertySource({"classpath:/db.properties"})
public class DaoConfig {
//	@Value("${jdbc.driver}")
	String driverClass;
//	@Value("${jdbc.url}")
	String url;
//	@Value("${jdbc.username}")
	String username;
//	@Value("${jdbc.password}")
	String password;
	
	@Bean(name="dataSource",destroyMethod="close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/treasures");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		try {
			dataSource.setFilters("stat");
		} catch (SQLException e) {
		}
		
		dataSource.setMaxActive(20);
		dataSource.setInitialSize(1);
		dataSource.setMaxWait(60000);
		dataSource.setMinIdle(1);
		
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		dataSource.setMinEvictableIdleTimeMillis(30000);
		
		dataSource.setValidationQuery("SELECT 'x'");
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		return dataSource;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate =  new JdbcTemplate();
		jdbcTemplate.setDataSource(this.dataSource());
		return jdbcTemplate;
	}
	
	@Bean(name="txManager")
	public DataSourceTransactionManager getTxManager(){
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(this.dataSource());
		return txManager;
	}
	
	@Bean(name="jdbcTool")
	public JdbcTemplateTool getJdbcTemplateTool() {
		JdbcTemplateTool tool = new JdbcTemplateTool();
		tool.setJdbcTemplate(this.jdbcTemplate());
		return tool;
	}
}
