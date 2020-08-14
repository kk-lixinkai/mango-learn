package com.mybestcoding.mango.backup.service.impl;

import com.mybestcoding.mango.backup.service.MysqlBackupService;
import com.mybestcoding.mango.backup.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

/**
 * Created By lixinkai on 2020/8/7
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {
    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
        return MySqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        return MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }
}
