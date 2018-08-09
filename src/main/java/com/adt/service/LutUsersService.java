package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutUsers;


public interface LutUsersService {
    public List<LutUsers> find(LutUsers lutUsers);
    public LutUsers view(LutUsers lutUsers);
    public void add(LutUsers lutUsers);
    public void edit(LutUsers lutUsers);
    public void remove(LutUsers lutUsers);
    public List<LutUsers> findAll();
    public LutUsers findById(String id);
    
    public List<LutUsers> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
