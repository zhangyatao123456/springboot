package com.yixue.xdatam.dao.sys;


import com.yixue.xdatam.entity.sys.AiKmapEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-25 15:26:57
 */
@Component
public interface AiKmapDao extends BaseDao<AiKmapEntity> {
    /**
     * 根据多字段查询
     *
     * @param aiKmapList
     * @param <T>
     * @return
     */
    public <T> List<T> findByNames(T aiKmapList);

    /**
     * 根据多个字段删除
     *
     * @param aiKmap
     * @throws Exception
     */
    public void deleteByNames(Object aiKmap) throws Exception;

    public void save(List<AiKmapEntity> aiKmapEntityList);

    /**
     * 查询最大图谱编号mid
     *
     * @return
     */
    public Long selectMaxMid();

    /**
     * 查询知识图谱编号是否存在
     *
     * @return
     */
    public String selectCode(String code);

    /**
     * 根据id拿图谱编号
     *
     * @param mid
     * @return
     */
    public String selectCodeById(Long mid);

    /**
     * 查询操作人
     *
     * @return
     */
    public String selectOperator();

    /**
     * 查询mid
     *
     * @param aiKmapEntity
     * @return
     */
    public Long selectMidByCode(AiKmapEntity aiKmapEntity);

}
