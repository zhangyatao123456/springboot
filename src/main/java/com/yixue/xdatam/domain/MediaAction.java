package com.yixue.xdatam.domain;

import java.io.Serializable;

/**
 * Created by zhang on 2018/3/7.
 */
public class MediaAction implements Serializable{
    /**
     * itemId	targetId所属ItemId	是	[array]
     */
    private String itemId;

    /**
     * itemType	targetId所属ItemType	是	[array]
     */
    private String itemType;

    /**
     * duration	item原始的时长（单位为秒）	是	[string]
     */
    private String duration;

    /**
     * currentTime	the current location（当前时间位置）	是	[string]
     */
    private String currentTime;
}
