package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkAuditFormFile;


public interface LnkAuditFormFileService {
    public List<LnkAuditFormFile> find(LnkAuditFormFile lnkAuditFormFile);
    public LnkAuditFormFile view(LnkAuditFormFile lnkAuditFormFile);
    public void add(LnkAuditFormFile lnkAuditFormFile);
    public void edit(LnkAuditFormFile lnkAuditFormFile);
    public void remove(LnkAuditFormFile lnkAuditFormFile);
    public List<LnkAuditFormFile> findAll();
    public LnkAuditFormFile findById(String id);
    
    public List<LnkAuditFormFile> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
