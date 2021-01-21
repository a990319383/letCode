package com.sangsang.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 哑巴湖大水怪
 * @date 2021/1/18 9:13
 * 包装一层tryCatch
 */
@Slf4j
public class CustomTryCatch {
    //把丑陋的try catch 包装一层
    public static <T> T wrap(TryCatchFunction<T> fun) {
        try {
            return fun.wrap();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(ExceptionUtil.getException(e));
        }
        return null;
    }

    //把丑陋的try catch 包装一层
    public static void voidWrap(TryCatchVoidFunction fun) {
        try {
            fun.voidWrap();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(ExceptionUtil.getException(e));
        }
    }

    @FunctionalInterface
    public interface TryCatchFunction<T> {
        T wrap() throws Exception;
    }

    @FunctionalInterface
    public interface TryCatchVoidFunction<T> {
        void voidWrap() throws Exception;
    }
}

