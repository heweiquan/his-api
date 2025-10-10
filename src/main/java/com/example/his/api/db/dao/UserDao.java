package com.example.his.api.db.dao;

import java.util.Set;

public interface UserDao {
    public Set<String> searchUserPermissions(int userId);
}




