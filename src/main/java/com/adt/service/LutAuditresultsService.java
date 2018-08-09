package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutAuditresults;


public interface LutAuditresultsService {
    public List<LutAuditresults> find(LutAuditresults lutAuditresults);
    public LutAuditresults view(LutAuditresults lutAuditresults);
    public void add(LutAuditresults lutAuditresults);
    public void edit(LutAuditresults lutAuditresults);
    public void remove(LutAuditresults lutAuditresults);
    public List<LutAuditresults> findAll();
    public LutAuditresults findById(String id);
    
    public List<LutAuditresults> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
