package com.aboo.vnet.web.main.core.util;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class webUtil_Sample {

    public static final String SERVER_SCHEME_HTTP = "http";
    public static final String SERVER_SCHEME_HTTPS = "https";
    public static final int SERVER_PORT_HTTP = 80;
    public static final int SERVER_PORT_HTTPS = 443;

    /** 服务器协议 **/
    private String serverScheme;

    /** 服务器端口 **/
    private int serverPort = -1;

    /** 服务器的主机名称 */
    private String serverHostName;

    /** 服务器的内部IP地址 */
    private String serverInnerIP;

    /**
     * 获得用户请求的真实URL。<br>
     * 与
     * <code>HttpServletRequest.getRequestURL()<code>的区别是，这个接口是根据服务器的Scheme、port配置构造
     * request的真实URL而不是根据rquest中的信息。<br>
     * 原因：在WEB服务器之前加上F5之后，客户端的https请求会被F5转换为对WEB服务器的http请求<br>
     * 
     * @param request
     * @return
     */
    public String getRequestURL(HttpServletRequest request) {
	StringBuffer buffer = new StringBuffer();

	boolean isDefaultPort = false;
	// http和80
	isDefaultPort |= (SERVER_SCHEME_HTTP.equals(serverScheme) && (serverPort == SERVER_PORT_HTTP));

	// https和443
	isDefaultPort |= (SERVER_SCHEME_HTTPS.equals(serverScheme) && (serverPort == SERVER_PORT_HTTPS));

	buffer.append(serverScheme).append("://")
		.append(request.getServerName());

	if (!isDefaultPort) {
	    buffer.append(":");
	    buffer.append(serverPort);
	}

	buffer.append(request.getRequestURI());

	return buffer.toString();
    }

    /**
     * 取得当前<code>HttpServletRequest<code>的URL以及参数（除了指定的参数）<br>
     * 主要适用于从当前页面跳转到其他页面，等其他页面完成工作后再跳转回本页面。<br>
     * 
     * @param request
     * 
     * @return
     */
    public String getRequestURLWithParameters(HttpServletRequest request) {
	String url = getRequestURL(request);
	String query = getRequestParameters(request);

	if (StringUtils.isNotBlank(query)) {
	    return url + "?" + query;
	} else {
	    return url;
	}
    }

    /**
     * 取得当前<code>HttpServletRequest<code>的URL以及参数（除了指定的参数）<br>
     * 主要适用于从当前页面跳转到其他页面，等其他页面完成工作后再跳转回本页面。<br>
     * 
     * @param request
     *            当前的访问请求
     * @param exceptParams
     *            去除的参数
     * @return 当前URL+参数字符串
     */
    public String getRequestURLWithParameters(HttpServletRequest request,
	    String[] exceptParams) {
	String url = getRequestURL(request);
	String query = getRequestParameters(request, exceptParams);

	if (StringUtils.isNotBlank(query)) {
	    return url + "?" + query;
	} else {
	    return url;
	}
    }

    /**
     * 取得请求中的所有参数，拼接成一个String.
     * 
     * @param request
     * 
     * @return
     */
    public String getRequestParameters(HttpServletRequest request) {
	return getRequestParameters(request, new String[] {});
    }

    /**
     * 取得请求中的所有参数(出去exceptParams中指定的参数)，拼接成一个String.
     * 
     * @param request
     * @param exceptParams
     * @return
     */
    public String getRequestParameters(HttpServletRequest request,
	    String[] exceptParams) {
	String query = "";
	StringBuffer sb = new StringBuffer();

	Enumeration<?> paramEnums = request.getParameterNames();

	// 获得当前编码
	String inputCharset = request.getCharacterEncoding();

	while (paramEnums.hasMoreElements()) {
	    String parmName = (String) paramEnums.nextElement();
	    String parmValue = request.getParameter(parmName);

	    try {
		if (StringUtils.isNotBlank(parmName)
			&& !ArrayUtils.contains(exceptParams, parmName)) {
		    // 必须删除安全性敏感的参数
		    sb.append(parmName + "="
			    + URLEncoder.encode(parmValue, inputCharset) + "&");
		}
	    } catch (Exception e) {
		// ignore
	    }
	}

	if (sb.length() > 0) {
	    int len = sb.length();

	    query = sb.substring(0, len - 1); // remove the last &
	} else {
	    query = null;
	}

	return query;
    }

    /**
     * Get an attribute from session.
     * 
     * <p>
     * Simple helper method hides the underlying session mechanism.
     * </p>
     * 
     * @param key
     * @param rundata
     * 
     * @return
     */
    public Object getSessionAttribute(String key, HttpServletRequest request) {
	return request.getSession().getAttribute(key);
    }

    /**
     * 设置session中变量的值.
     * 
     * @param key
     * @param value
     * @param rundata
     */
    public void setSessionAttribute(String key, Object value,
	    HttpServletRequest request) {
	if ((request != null) && StringUtils.isNotBlank(key)) {
	    request.getSession().setAttribute(key, value);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
	try {
	    serverHostName = InetAddress.getLocalHost().getHostName();
	    serverInnerIP = InetAddress.getLocalHost().getHostAddress();
	} catch (UnknownHostException uhe) {
	    throw new RuntimeException("无法取得服务器主机信息", uhe);
	}

	if (StringUtils.isBlank(serverScheme)) {
	    throw new IllegalArgumentException("没有配置serverScheme！");
	}

	if (serverPort < 0) {
	    throw new IllegalArgumentException("没有配置serverPort！");
	}
    }

    /**
     * @param serverPort
     */
    public void setServerPort(int serverPort) {
	this.serverPort = serverPort;
    }

    /**
     * 获得当前主机的端口
     * 
     * @return
     */
    public int getServerPort() {
	return serverPort;
    }

    /**
     * @param serverScheme
     */
    public void setServerScheme(String serverScheme) {
	this.serverScheme = serverScheme;
    }

    /**
     * 获得当前主机的协议（http或https）
     * 
     * @return
     */
    public String getServerScheme() {
	return serverScheme;
    }

    /**
     * 获得当前服务器的内部IP
     * 
     * @return
     */
    public String getServerInnerIP() {
	return serverInnerIP;
    }

    /**
     * 获得当前服务器的主机名称
     * 
     * @return
     */
    public String getServerHostName() {
	return serverHostName;
    }

}