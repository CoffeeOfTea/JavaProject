package com.xb14620103.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * �������һ��ID
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-","").toUpperCase();
	}
	/**
	 * �������������
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
}
