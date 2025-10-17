package com.example.his.api.db.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface UserDao {
    public Set<String> searchUserPermissions(int userId);

    public Integer login(Map param);

    public String searchUsernameById(int userId);

    public int updatePassword(Map param);

    public ArrayList<HashMap> searchByPage(Map param);

    public long searchCount(Map param);
}




