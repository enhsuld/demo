package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutAuditLevel;


public interface LutAuditLevelService {
    public List<LutAuditLevel> find(LutAuditLevel lutAuditLevel);
    public LutAuditLevel view(LutAuditLevel lutAuditLevel);
    public void add(LutAuditLevel lutAuditLevel);
    public void edit(LutAuditLevel lutAuditLevel);
    public void remove(LutAuditLevel lutAuditLevel);
    public List<LutAuditLevel> findAll();
    public LutAuditLevel findById(String id);
    
    public List<LutAuditLevel> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
