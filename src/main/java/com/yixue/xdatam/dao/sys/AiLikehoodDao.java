package com.yixue.xdatam.dao.sys;


import com.yixue.xdatam.entity.sys.AiLikehoodEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2017-07-13 17:04:05
 */
@Component
public interface AiLikehoodDao extends BaseDao<AiLikehoodEntity> {
    public void saveLikehoodList(List<AiLikehoodEntity> aiLikehoodEntityList);

}
