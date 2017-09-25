package com.aboo.vnet.web.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.aboo.vnet.web.main.core.constant.WebConst;

public class SysController {

    /** 登录跳转标识 */
    public static final String GOTO = WebConst.GOURL;

    /** 处理成功标识 */
    public static final String SUCCESS = "success";

    /** 处理失败code标识 */
    public static final String ERROR = "error";

    /** 处理结果描述msg */
    public static final String MSG = "msg";

    /** forward标识 */
    public static final String FORWARD = "forward:";

    /** redirect标识 */
    public static final String REDIRECT = "redirect:";
    // ------------------------------------------------------------------
    // 系统相关页面
    /** 用户登录页面 */
    protected static final String LOGIN_PAGE = "login";


    // ------------------------------------------------------------------

    // ************************** session 设置 ******************************** //
    /** HttpServletRequest 设置 session */
    protected void setSession(HttpServletRequest request, String name,
	    Object value) {
	request.getSession().setAttribute(name, value);
    }

    /** WebRequest 设置 session */
    protected void setSession(WebRequest request, String name, Object value) {
	request.setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
    }

    // ************************** cookie设置 ******************************** //
    /** 添加cookie */
    protected void addCookie(HttpServletResponse response, String name,
	    String value, String domain, String path) {
	addCookie(response, name, value, domain, path, 0);
    }

    /** 添加cookie */
    protected void addCookie(HttpServletResponse response, String name,
	    String value, String domain, String path, int maxAge) {
	addCookie(response, name, value, domain, path, maxAge, false);
    }

    /** 添加cookie */
    protected void addCookie(HttpServletResponse response, String name,
	    String value, String domain, String path, int maxAge,
	    boolean httpOnly) {
	addCookie(response, name, value, domain, path, maxAge, httpOnly, false);
    }

    /** 添加cookie */
    protected void addCookie(HttpServletResponse response, String name,
	    String value, String domain, String path, int maxAge,
	    boolean httpOnly, boolean secure) {
	addCookie(response, name, value, domain, path, maxAge, httpOnly,
		secure, "", 0);
    }

    /** 添加cookie到客户端 */
    private void addCookie(HttpServletResponse response, String name,
	    String value, String domain, String path, int maxAge,
	    boolean httpOnly, boolean secure, String comment, int version) {
	Cookie cookie = new Cookie(name, value);
	cookie.setDomain(domain);
	cookie.setPath(path);
	if (maxAge != 0) {
	    cookie.setMaxAge(maxAge);
	}
	// servlet3.0+ 支持
	// cookie.setHttpOnly(httpOnly);
	cookie.setSecure(secure);
	cookie.setComment(comment);
	cookie.setVersion(version);

	response.addCookie(cookie);
    }

    /** 删除Cookie */
    protected void delCookie(HttpServletResponse response, String name) {
	Cookie cookie = new Cookie("name", null);
	cookie.setMaxAge(0);
	response.addCookie(cookie);
    }
}
