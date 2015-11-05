package cn.ryanwu.indiana.common;

import java.util.Map;
import java.util.TreeMap;

/**
 * ״ֵ̬
 * 
 * @author WSP&WD
 *
 */
public enum ResponseStatus {

	NOT_LOGIN(126, "未登录"), NO_AUTH(127, "无权限"), FAILED(128, "请求操作失败"), SUCCESS(
			200, "请求操作成功"), REDIRECT(301, "请求重定向"), TIMEOUT(300, "请求超时"), NOT_FOUND(
			404, "请求未找到"), SYSTEM_ERROR(500, "服务器错误");

	private int status;
	private String value;

	private ResponseStatus(int status, String value) {
		this.status = status;
		this.value = value;
	}

	private static Map<Integer, ResponseStatus> map = new TreeMap<Integer, ResponseStatus>();

	static {
		for (ResponseStatus status : values()) {
			map.put(status.status, status);
		}
	}

	public static ResponseStatus of(int status) {
		return map.get(status);
	}

	public static String valueOf(int status) {
		ResponseStatus responseStatus = map.get(status);
		if (responseStatus != null) {
			return responseStatus.value;
		} else {
			return null;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}