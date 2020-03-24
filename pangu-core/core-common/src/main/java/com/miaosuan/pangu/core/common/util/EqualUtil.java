package com.miaosuan.pangu.core.common.util;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 相等比较
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
public final class EqualUtil {


    public static Boolean isEq(Long value1, Long value2) {
        if (Objects.nonNull(value1) && Objects.nonNull(value2)) {
            return value1.longValue() == value2.longValue();
        }

        return false;
    }


    public static Boolean isEq(String str1, String str2) {
        if (Objects.nonNull(str1) && Objects.nonNull(str2)) {
            return str1.equals(str2);
        }
        return false;
    }

    public static Boolean isIn(String str1, String... strArray) {
        Preconditions.checkNotNull(str1);
        Preconditions.checkNotNull(strArray);

        for (int i = 0; i < strArray.length; i++) {
            String item = strArray[i];

            if (isEq(str1, item)) {
                return true;
            }
        }

        return false;
    }


}
