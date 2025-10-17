package com.example.his.api.mis.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.example.his.api.db.dao.UserDao;
import com.example.his.api.mis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Integer login(Map param) {
        String username = MapUtil.getStr(param, "username");
        String password = MapUtil.getStr(param, "password");
        MD5 md5 = MD5.create();
        String temp = md5.digestHex(username);
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        password = md5.digestHex(tempStart + password + tempEnd).toUpperCase();
        param.replace("password", password);
        Integer userId = userDao.login(param);
        return userId;
    }

    @Override
    public int updatePassword(Map param) {
        int userId = MapUtil.getInt(param, "userId");
        String username = userDao.searchUsernameById(userId);

        MD5 md5 = MD5.create();
        String password = MapUtil.getStr(param, "password");
        String temp = md5.digestHex(username);
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        password = md5.digestHex(tempStart + password + tempEnd).toUpperCase();
        param.replace("password", password);

        String newPassword = MapUtil.getStr(param, "newPassword");
        newPassword = md5.digestHex(tempStart + newPassword + tempEnd).toUpperCase();
        param.replace("newPassword", newPassword);

        int rows = userDao.updatePassword(param);
        return rows;
    }
}