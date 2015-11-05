package cn.ryanwu.indiana.utils;

import org.apache.commons.lang.StringUtils;

import cn.ryanwu.indiana.common.ResponseData;
import cn.ryanwu.indiana.common.ResponseStatus;



/**
 * 返回数据工具类
 * @author WSP&WD
 *
 */
public class ResponseUtil {

	public static ResponseData success() {
		return success(null, null);
	}
	
	public static ResponseData success(Object data) {
		return success(data, null);
	}

	public static ResponseData success(Object data, String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.SUCCESS);
		responseData.setData(data);
		return responseData;
	}

	public static ResponseData failed() {
		return failed(null);
	}

	public static ResponseData failed(String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.FAILED);
		return responseData;
	}

	public static ResponseData redirect(String redirectUrl) {
		return redirect(redirectUrl, null);
	}

	public static ResponseData redirect(String redirectUrl, String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.REDIRECT);
		responseData.setData(redirectUrl);
		return responseData;
	}

	public static ResponseData notLogin() {
		return notLogin(null);
	}

	public static ResponseData notLogin(String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.NOT_LOGIN);
		return responseData;
	}

	public static ResponseData noAuth() {
		return noAuth(null);
	}

	public static ResponseData noAuth(String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.NO_AUTH);
		return responseData;
	}

	public static ResponseData notFound() {
		return notFound(null);
	}

	public static ResponseData notFound(String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.NOT_FOUND);
		return responseData;
	}

	public static ResponseData systemError() {
		return systemError(null);
	}

	public static ResponseData systemError(String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.SYSTEM_ERROR);
		return responseData;
	}

	public static ResponseData timeout() {
		return timeout(null);
	}

	public static ResponseData timeout(String message) {
		ResponseData responseData = getResponseData(message,
				ResponseStatus.TIMEOUT);
		return responseData;
	}

	private static ResponseData getResponseData(String message,
			ResponseStatus responseStatus) {
		ResponseData responseData = new ResponseData();
		if (StringUtils.isBlank(message)) {
			responseData.setMessage(responseStatus.getValue());
		} else {
			responseData.setMessage(message);
		}
		responseData.setStatus(responseStatus.getStatus());
		return responseData;
	}

}