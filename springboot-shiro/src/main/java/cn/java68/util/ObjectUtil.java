package cn.java68.util;

import org.springframework.util.Assert;

public class ObjectUtil {
    /**
     * 判断一个对象是否不为空
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        Boolean checkState = Boolean.TRUE;
        try {
            Assert.notNull(obj, "");
        } catch (IllegalArgumentException e) {
            checkState = Boolean.FALSE;
        }
        return checkState;
    }

    public static boolean isNull(Object obj) {
        Boolean checkState = Boolean.TRUE;
        try {
            Assert.isNull(obj, "");
        } catch (Exception e) {
            checkState = Boolean.FALSE;
        }
        return checkState;
    }
}