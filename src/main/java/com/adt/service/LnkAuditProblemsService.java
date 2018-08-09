package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkAuditProblems;


public interface LnkAuditProblemsService {
    public List<LnkAuditProblems> find(LnkAuditProblems lnkAuditProblems);
    public LnkAuditProblems view(LnkAuditProblems lnkAuditProblems);
    public void add(LnkAuditProblems lnkAuditProblems);
    public void edit(LnkAuditProblems lnkAuditProblems);
    public void remove(LnkAuditProblems lnkAuditProblems);
    public List<LnkAuditProblems> findAll();
    public LnkAuditProblems findById(String id);
    
    public List<LnkAuditProblems> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
