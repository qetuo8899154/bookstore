package utils;

import java.util.UUID;

public class CommonUtils {
	/**
	 * 生成uuid
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
