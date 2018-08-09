package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkUserrole;


public interface LnkUserroleService {
    public List<LnkUserrole> find(LnkUserrole lnkUserrole);
    public LnkUserrole view(LnkUserrole lnkUserrole);
    public void add(LnkUserrole lnkUserrole);
    public void edit(LnkUserrole lnkUserrole);
    public void remove(LnkUserrole lnkUserrole);
    public List<LnkUserrole> findAll();
    public LnkUserrole findById(String id);
    
    public List<LnkUserrole> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
