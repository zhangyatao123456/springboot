package com.yixue.xdatam.dao.sys;

import com.yixue.xdatam.entity.sys.AiPreNodeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-31 17:16:23
 */
@Component
public interface AiPreNodeDao extends BaseDao<AiPreNodeEntity> {
    public void deleteLatestData();

    public void deleteByNodeCode(@Param("nodeCode") String nodeCode, @Param("mid") Long mid);

    public void saveAiPre(List<AiPreNodeEntity> aiPreEntityList);

    public List<AiPreNodeEntity> selectPreNodes(AiPreNodeEntity aiPreNodeEntity);
}
