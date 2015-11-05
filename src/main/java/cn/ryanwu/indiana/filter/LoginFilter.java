package cn.ryanwu.indiana.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import cn.ryanwu.indiana.model.Customer;
import cn.ryanwu.indiana.service.CustomerService;
import cn.ryanwu.indiana.utils.ResponseUtil;
import cn.ryanwu.indiana.utils.ServletUtil;

@Component("loginFilter")
public class LoginFilter implements Filter {

	private static final String TREASURE_HEADER_ID = "X-TREASURE-HEADER-ID";

	@Autowired
	protected CustomerService customerService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String treasure = ((HttpServletRequest) request)
				.getHeader(TREASURE_HEADER_ID);

		if (StringUtils.isBlank(treasure) || customerService.getCustomerFormCache(treasure) == null) {
			ServletUtil.printJson(ResponseUtil.notLogin(),
					(HttpServletRequest) request,
					(HttpServletResponse) response);
		}else {
			filterChain.doFilter(request, response);
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
