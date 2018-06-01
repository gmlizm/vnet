package com.aboo.vnet.web.main.core.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 网络信息工具类
 * 
 * @author zhuxq
 * @version $Id: NetworkUtils.java, v 0.1 May 17, 2013 4:41:49 PM zhuxq Exp $
 */
public class NetworkUtils {

	private final static byte[] hex = "0123456789ABCDEF:".getBytes();

	/** loopback地址 */
	private final static String LOOP_BACK = "localhost";

	/**
	 * 获取本地的IP地址
	 * 
	 * @return
	 */
	public static String getAllIPs() {
		List<String> res = new ArrayList<String>();
		Enumeration<NetworkInterface> netInterfaces;
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			return null;
		}
		if (netInterfaces == null)
			return null;
		while (netInterfaces.hasMoreElements()) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> nii = ni.getInetAddresses();
			while (nii.hasMoreElements()) {
				InetAddress ip = nii.nextElement();
				String ipaddr = ip.getHostAddress();
				// 去除IPV6地址及loopback地址
				if (ipaddr.indexOf(":") == -1 && !ipaddr.equals(LOOP_BACK)) {
					res.add(ipaddr);
				}

			}
		}
		return res.toString();
	}

	/**
	 * 获取本机的MAC地址
	 * 
	 * @return
	 */
	public static String getAllMacs() {
		List<String> res = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				byte[] mac = ni.getHardwareAddress();
				if (!ArrayUtils.isEmpty(mac)) {
					res.add(bytes2HexString(mac));
				}
			}
		} catch (SocketException e) {
			return null;
		}
		return res.toString();
	}

	/**
	 * 字节数组转16进制格式
	 * 
	 * @param b
	 * @return
	 */
	private static String bytes2HexString(byte[] b) {
		byte[] buff = new byte[3 * b.length];
		for (int i = 0; i < b.length; i++) {
			buff[3 * i] = hex[(b[i] >> 4) & 0x0f];
			buff[3 * i + 1] = hex[b[i] & 0x0f];
			buff[3 * i + 2] = hex[16];
		}
		String str = new String(buff);
		return str.substring(0, str.length() - 1);
	}
}
