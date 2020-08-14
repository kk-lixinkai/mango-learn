package com.mybestcoding.mango.backup.util;

import java.io.File;
import java.io.IOException;

/**
 * MySQL备份还原工具类
 * Created By lixinkai on 2020/8/7
 */
public class MySqlBackupRestoreUtils {

    /**
     * 备份数据库
     *
     * @param host             host地址，可以是本机也可以是远程
     * @param userName         数据库的用户名
     * @param password         数据库的密码
     * @param backupFolderPath 备份的路径
     * @param fileName         备份的文件名
     * @param database         需要备份的数据库的名称
     * @return
     * @throws Exception
     */
    public static boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在则创建
            backupFolderFile.mkdirs();
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }
        // 拼接命令行命令
        String backupFilePath = backupFolderPath + fileName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt").append(" --add-drop-database ").append(" --add-drop-table ");
        stringBuilder.append(" -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database);
        // 调用外部执行 exe 文件的 Java API
        Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
        if (process.waitFor() == 0) {
            // 0 标识线程正常终止
            System.out.println("数据已备份到 " + backupFilePath + " 文件中");
            return true;
        }
        return false;
    }

    public static boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if (os.toLowerCase().startsWith("win")) {
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = {shell, c, command};
        return cmd;
    }
}
