package com.yixue.xdatam.common.plugin;




import com.yixue.common.util.encrypt.AESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 支持加密配置文件插件
 * Created by robinwb on 2017/2/4.
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = {
		"master.jdbc.password", "slave.jdbc.password", "generator.jdbc.password", "master.redis.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue)  {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				try {
					return AESUtils.encrypt(propertyValue,propertyName);//.AESDecode(propertyValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
