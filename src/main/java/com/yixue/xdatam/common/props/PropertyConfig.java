package com.yixue.xdatam.common.props;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author robinwb
 * @date 2016-08-23
 */
public class PropertyConfig {
	private static String default_config = PropertyConfig.class.getClassLoader().getResource("sysconfig.properties").getPath();
	private static String configBasePath = "";
	private static Properties mConfig=new Properties();
	private static FileInputStream in;
	private static File file;
	private static List<String> proplist = new ArrayList<String>();
	private static Map<String, Properties> propmap = new HashMap<String, Properties>();
	private static boolean flaginit = true; //自定义文件是否已经加载


	static {
		// 重新获取配置文件
		mConfig = new Properties();
		file = new File(default_config);
		try {
			in = new FileInputStream(file);
			mConfig.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			//log.error("配置文件路径不正确！");
			//log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			//log.error(e);
			e.printStackTrace();
		}
	}

	public PropertyConfig() {
		super();
	}
	public static void main(String[] args) {
		System.err.println(PropertyConfig.getDoubleProperty("VOCAB.ABLITITY.WEIGTH"));
		System.err.println(PropertyConfig.getDoubleProperty("GRAMMAR.ABLITITY.WEIGTH"));
		System.err.println(PropertyConfig.getDoubleProperty("READ.ABLITITY.WEIGTH"));
		System.err.println(PropertyConfig.getDoubleProperty("TIME.RANGE1.MAX"));
		System.err.println(PropertyConfig.getDoubleProperty("TIME.RANGE2.MAX"));
		System.err.println(PropertyConfig.getDoubleProperty("TIME.RANGE3.MAX"));

		System.err.println(PropertyConfig.getDoubleProperty("TIME.RANGE1.OFFSET"));
		System.err.println(PropertyConfig.getDoubleProperty("TIME.RANGE2.OFFSET"));
		System.err.println(PropertyConfig.getDoubleProperty("TIME.RANGE3.OFFSET"));
		System.err.println(PropertyConfig.getDoubleProperty("STANDARD.ABILITY.MIN"));
		System.err.println(PropertyConfig.getDoubleProperty("STANDARD.ABILITY.MAX"));

	}
	/**
	 * @param key key的名称
	 * @return key对应的值
	 * @author robinwb
	 */
	public static String getProperty(String key) {
		// 判断文件是否被修改过。
		boolean flag = ConfigManager.isLastModifiedChanged(default_config);
		if (flag) {
			//log.debug("获取key值：=" + key);
			return mConfig.getProperty(key);
		} else {
			//log.debug("获取key值：=" + key);
			return mConfig.getProperty(key);
		}
	}

	/**
	 *@author robinwb
	 *  获取自定properties文件内的key对应的value
	 */
	/**
	 * 获取自定properties文件内的key对应的value
	 * @param key
	 * @param dictPath 自定义文件路径(目录)
	 * @return key对应的值
	 * @author robinwb
	 */
	public static String getProperty(String key, String dictPath) {
		String value = null;
		if (flaginit) {
			loadconfig(dictPath);
			flaginit = false;
		}

		for (int i = 0; i < proplist.size(); i++) {
			setPropList(proplist.get(i));
			Properties dprop = propmap.get(proplist.get(i));
			String valuestr = (String) dprop.get(key);
			if (valuestr != null) {
				value = valuestr;
				//log.info("从文件" + proplist.get(i) + "获取value值");
				break;
			}
		}

		return value;
	}
	/**
	 * 将文件中的数据加载到内存中
	 * @param filepath 文件路径(含文件名)
	 * @author robinwb
	 */
	public static void setPropList(String filepath) {
		boolean flag = ConfigManager.isLastModifiedChanged(filepath);
		if (flag) {
			// 重新获取配置文件

			if (!proplist.contains(filepath)) {
				proplist.add(filepath);
			}
			file = new File(filepath);
			try {
				in = new FileInputStream(file);
				Properties pc = propmap.get(filepath);
				if (pc == null) {
					pc = new Properties();
				} else {
					propmap.remove(filepath);
				}

				pc.load(in);
				propmap.put(filepath, pc);
				in.close();
			} catch (FileNotFoundException e) {
				//log.error("配置文件路径不正确！");
				//log.error(e);
				e.printStackTrace();
			} catch (IOException e) {
				//log.error(e);
				e.printStackTrace();
			}

		}

	}

	/**
	 *@author robinwb
	 *  加载prop下所有的properties文件
	*/
	public static void loadconfig(String filepath) {
		File inThePath = new File(filepath);// 建立当前目录中文件的File对象
		File list[] = inThePath.listFiles(); // 取得代表目录中所有文件的File对象数组
		Collector(filepath, list);
	}

	/**
	 * 遍历所有的properties文件,并保存到缓存中
	 * @param xmlPath
	 * @param list
	 * @author robinwb
	 */
	private static void Collector(String xmlPath, File list[]) {
		String filename = "";
		try {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isFile()) {
					filename = list[i].getName();
					if (filename.toLowerCase().endsWith(".properties")) {
						//log.info(xmlPath +File.separator+ filename);
						setPropList(xmlPath + File.separator + filename);
					}
				} else { // list[i].isDirectory()
					String path = xmlPath + list[i].getName() + File.separator;
					File filepath = new File(path);
					Collector(path, filepath.listFiles());
				}
			}
		} catch (Exception e) {
			//log.error("解析文件出错:" + xmlPath + filename + "\n" + e);
		}
	}

	/**
	 * 获取指定Key的Boolean值 ，如果值为null 则设置为默认值
	 * @param name  key的名称
	 * @param defaultValue 默认值
	 * @return key对应的Boolean值
	 * @author robinwb
	 */
	public static boolean getBooleanProperty(String name, boolean defaultValue) {
		String value = PropertyConfig.getProperty(name);

		if (value == null)
			return defaultValue;

		return (new Boolean(value)).booleanValue();
	}
	/**
	 * 获取指定Key的double值 ，如果值为null 则设置为默认值
	 * @param keyname  key的名称
	 * @param defaultValue 默认值
	 * @return key对应的Double值
	 * @author robinwb
	 */
	public static double getDoubleProperty(String keyname, double defaultValue) {
		if (keyname==null||"".equals(keyname.trim())) return defaultValue;
		String value = PropertyConfig.getProperty(keyname);
		if (value == null||"".equals(value)) return defaultValue;
		return Double.parseDouble(value);
	}
	/**
	 * 获取指定Key的double值 ，如果值为null 则设置为默认值
	 * @param keyname  key的名称
	 * @return key对应的Double值
	 * @author robinwb
	 */
	public static double getDoubleProperty(String keyname) {
		return  getDoubleProperty(keyname,0.0);
	}
	/**
	 * 获取指定Key的Integer值
	 * @param name key的名称
	 * @return key对应的Integer 值
	 * @author robinwb
	 */
	public static int getIntProperty(String name) {
		return getIntProperty(name, 0);
	}
	/**
	 * 获取指定Key的Integer值 ，如果值为null 则设置为默认值
	 * @param name  key的名称
	 * @param defaultValue 默认值
	 * @return key对应的Integer值
	 * @author robinwb
	 */
	public static int getIntProperty(String name, int defaultValue) {
		String value = PropertyConfig.getProperty(name);

		if (value == null)
			return defaultValue;
		return (new Integer(value)).intValue();
	}
}
