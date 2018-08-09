package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutRole;


public interface LutRoleService {
    public List<LutRole> find(LutRole lutRole);
    public LutRole view(LutRole lutRole);
    public void add(LutRole lutRole);
    public void edit(LutRole lutRole);
    public void remove(LutRole lutRole);
    public List<LutRole> findAll();
    public LutRole findById(String id);
    
    public List<LutRole> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
