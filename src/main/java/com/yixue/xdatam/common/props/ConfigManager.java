package com.yixue.xdatam.common.props;


import java.io.File;
import java.util.HashMap;

/**
 * 配置管理类
 * @author  robinwb
 * @date 2016-08-23
 */
public class ConfigManager {
	private static String xmlFilePath;
	private static HashMap<String, String> lastModifiedMap = new HashMap<String, String>(); //xml文件的最新修改时间的map
	public ConfigManager(){
	}
	/**
	 * 判断文件是否被修改，true为修改，false为未修改，首次访问为true
	 * parma 文件的路径及名称
	 * @return boolean
	 * @author robinwb
	 */
	public static boolean isLastModifiedChanged(String confPath) {
		boolean lastModifiedChanged = false;
		try{
		File inputXml = new File(confPath);
		String oldTime = String.valueOf(lastModifiedMap.get(confPath));
		String newWriteTime = String.valueOf(inputXml.lastModified());
		if (oldTime == null || "null".equals(oldTime)) {
			lastModifiedMap.put(confPath, newWriteTime);
			lastModifiedChanged = true;
		} else {
			if (oldTime.equals(newWriteTime)) {
				lastModifiedChanged = false;
			} else {
				lastModifiedMap.put(confPath, newWriteTime);
				lastModifiedChanged = true;
			}
		}
		}catch(Exception e){
		}
		return lastModifiedChanged;
	}

}
