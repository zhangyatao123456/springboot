package com.yixue.xdatam.base;


import java.util.List;
import java.util.Map;

/**
 * BaseService接口
 * Created by Robinwb on 2017/01/07.
 */
public interface BaseService<T> {

	int save(T t);

	int saveByMap(Map<String, Object> map);

	int saveBatch(List<T> list);

	int update(T t);

	int updateByMap(Map<String, Object> map);

	int delete(Object id);

	int deleteByMap(Map<String, Object> map);

	int deleteBatch(Object[] id);

	T queryObjectById(Object id);

	List<T> queryListByMap(Map<String, Object> map);

	List<T> queryList(Object id);

	void initMapper();

}
