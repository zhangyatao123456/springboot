package com.yixue.xdatam.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常量
 *
 * @author robinwb
 * @email wangbiao@classba.cn
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;

    /**
     * 菜单类型
     *
     * @author robinwb
     * @email wangbiao@classba.cn
     * @date 2016年11月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     *
     * @author robinwb
     * @email wangbiao@classba.cn
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        private CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 日期处理
     *
     * @author robinwb
     * @email wangbiao@classba.cn
     * @date 2016年12月21日 下午12:53:33
     */
    public static class DateUtils {
        /**
         * 时间格式(yyyy-MM-dd)
         */
        public final static String DATE_PATTERN = "yyyy-MM-dd";
        /**
         * 时间格式(yyyy-MM-dd HH:mm:ss)
         */
        public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

        public static String format(Date date) {
            return format(date, DATE_PATTERN);
        }

        public static String format(Date date, String pattern) {
            if (date != null) {
                SimpleDateFormat df = new SimpleDateFormat(pattern);
                return df.format(date);
            }
            return null;
        }
    }
}
