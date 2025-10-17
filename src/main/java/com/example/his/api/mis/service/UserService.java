package com.example.his.api.mis.service;

import java.util.Map;

public interface UserService {
    public Integer login(Map param);

    public int updatePassword(Map param);
}
