package com.yixue.xdatam.dao.sys;

import com.yixue.xdatam.entity.sys.AiNodeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-05-31 17:16:23
 */
@Component
public interface AiNodeDao extends BaseDao<AiNodeEntity> {
    public void saveAiNode(List<AiNodeEntity> aiNodeEntityList);

    List<AiNodeEntity> selectMapMessageList(Map<String, Object> map);

    List<AiNodeEntity> selectMapMessageListCount(Map<String, Object> map);

    List<AiNodeEntity> selectTest();

    Long selectMidByNid(Long nid);

    void deleteByMid(Long mid);

    Long selectMid(Long mid);

    List<AiNodeEntity> selectObj(Long mid);

    String selectDesc(@Param("code") String code, @Param("mid") Long mid);
}
