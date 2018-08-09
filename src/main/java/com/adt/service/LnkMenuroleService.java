package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkMenurole;


public interface LnkMenuroleService {
    public List<LnkMenurole> find(LnkMenurole lnkMenurole);
    public LnkMenurole view(LnkMenurole lnkMenurole);
    public void add(LnkMenurole lnkMenurole);
    public void edit(LnkMenurole lnkMenurole);
    public void remove(LnkMenurole lnkMenurole);
    public List<LnkMenurole> findAll();
    public LnkMenurole findById(String id);
    
    public List<LnkMenurole> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
