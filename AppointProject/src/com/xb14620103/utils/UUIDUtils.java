package com.xb14620103.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 随机生成一个ID
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-","").toUpperCase();
	}
	/**
	 * 随机生成令牌码
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
}
