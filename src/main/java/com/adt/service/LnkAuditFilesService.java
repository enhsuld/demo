package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkAuditFiles;


public interface LnkAuditFilesService {
    public List<LnkAuditFiles> find(LnkAuditFiles lnkAuditFiles);
    public LnkAuditFiles view(LnkAuditFiles lnkAuditFiles);
    public void add(LnkAuditFiles lnkAuditFiles);
    public void edit(LnkAuditFiles lnkAuditFiles);
    public void remove(LnkAuditFiles lnkAuditFiles);
    public List<LnkAuditFiles> findAll();
    public LnkAuditFiles findById(String id);
    
    public List<LnkAuditFiles> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
