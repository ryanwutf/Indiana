package cn.ryanwu.indiana.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController{

    @RequestMapping(value="/error",produces="application/json")
    @ResponseBody
    public Map<String, Object> error(HttpServletRequest request) {
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("message", request.getAttribute("javax.servlet.error.message"));
        return map;
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

	
    
   
}
