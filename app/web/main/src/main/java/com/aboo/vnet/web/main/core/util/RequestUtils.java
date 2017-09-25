package com.aboo.vnet.web.main.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对于超时的参数请求处理
 * 
 * @author wb-tianyc
 * @version $Id: RequestUtils.java,v 0.1 2010-7-6 上午09:41:33 wb-tianyc Exp $
 */
public class RequestUtils {

	/** logger */
	private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

	/**
	 * 将parameters重新组装成query string。
	 *
	 * @param params
	 * @return query string，如果没有参数，则返回<code>null</code>
	 */
	public static String toQueryString(final Map<String, String[]> params) {
		final StringBuilder buffer = new StringBuilder();

		for (final Map.Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();
			final Object[] values = entry.getValue();

			if (ArrayUtils.isEmpty(values)) {
				continue;
			}

			key = StringEscapeUtil.escapeURL(key);

			for (Object valueObject : values) {
				if (valueObject == null) {
					valueObject = "";
				}

				if (valueObject instanceof String) {
					if (buffer.length() > 0) {
						buffer.append("&");
					}

					try {
						String value = StringEscapeUtil.escapeURL((String) valueObject, "GBK");
						buffer.append(key).append("=").append(value);
					} catch (UnsupportedEncodingException e) {
						logger.warn("对valueObject：" + valueObject + "进行GBK编码失败");
					}

				}
			}
		}

		if (buffer.length() == 0) {
			return null;
		}

		return buffer.toString();
	}

	/**
	 * Constructor RequestUtils creates a new RequestUtils instance.
	 */
	private RequestUtils() {
	}

}
