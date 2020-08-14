package com.mybestcoding.mango.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

/**
 * POI相关操作
 * Created By lixinkai on 2020/8/2
 */
public class PoiUtils {

    /**
     * 生成Excel文件
     *
     * @param workbook
     * @param fileName
     * @return
     */
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsolutePath());
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
