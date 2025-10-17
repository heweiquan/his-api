package com.example.his.api.mis.service;

import com.example.his.api.common.PageUtils;

import java.util.Map;

public interface UserService {
    public Integer login(Map param);

    public int updatePassword(Map param);

    public PageUtils searchByPage(Map param);
}
