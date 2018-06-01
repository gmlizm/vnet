package com.aboo.vnet.web.main.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aboo.vnet.web.main.core.constant.WebConst;

public class webUtil implements WebConst {

    /** 日志工具 */
    private static final Logger logger = LoggerFactory.getLogger(webUtil.class);

    public static String getURL(HttpServletRequest request) {
	if (request == null) {
	    return "";
	}
	StringBuffer buffer = new StringBuffer();
	buffer.append(request.getScheme()).append("://")
		.append(request.getServerName())
		.append(":" + request.getServerPort())
		.append(request.getServletPath());
	return buffer.toString();
    }

    public static String getFullURL(HttpServletRequest request) {
	if (request == null) {
	    return "";
	}
	StringBuffer buffer = new StringBuffer();
	buffer.append(request.getScheme()).append("://")
		.append(request.getServerName()).append(":")
		.append(request.getServerPort())
		.append(request.getServletPath());

	String query = request.getQueryString();
	if (query != null && !"".equals(query.trim())) {
	    buffer.append("?").append(request.getQueryString());
	}
	return buffer.toString();
    }

    public static String encode(String param) {
	try {
	    String result = URLEncoder.encode(param, CHARSET);
	    return result;
	} catch (UnsupportedEncodingException e) {
	    // 理论上不可能发生
	    logger.warn("不支持的字符集【" + CHARSET + "】");
	    return param;
	}
    }

    public static String encodeFullURL(HttpServletRequest request) {
	return encode(getFullURL(request));
    }
}
