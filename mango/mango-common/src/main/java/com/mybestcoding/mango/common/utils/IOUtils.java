package com.mybestcoding.mango.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具类
 * Created By lixinkai on 2020/8/2
 */
public class IOUtils {

    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException e) {

        }
    }
}
