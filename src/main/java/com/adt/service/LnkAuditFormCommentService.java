package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkAuditFormComment;


public interface LnkAuditFormCommentService {
    public List<LnkAuditFormComment> find(LnkAuditFormComment lnkAuditFormComment);
    public LnkAuditFormComment view(LnkAuditFormComment lnkAuditFormComment);
    public void add(LnkAuditFormComment lnkAuditFormComment);
    public void edit(LnkAuditFormComment lnkAuditFormComment);
    public void remove(LnkAuditFormComment lnkAuditFormComment);
    public List<LnkAuditFormComment> findAll();
    public LnkAuditFormComment findById(String id);
    
    public List<LnkAuditFormComment> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
