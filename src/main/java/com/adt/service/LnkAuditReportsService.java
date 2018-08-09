package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkAuditReports;


public interface LnkAuditReportsService {
    public List<LnkAuditReports> find(LnkAuditReports lnkAuditReports);
    public LnkAuditReports view(LnkAuditReports lnkAuditReports);
    public void add(LnkAuditReports lnkAuditReports);
    public void edit(LnkAuditReports lnkAuditReports);
    public void remove(LnkAuditReports lnkAuditReports);
    public List<LnkAuditReports> findAll();
    public LnkAuditReports findById(String id);
    
    public List<LnkAuditReports> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
