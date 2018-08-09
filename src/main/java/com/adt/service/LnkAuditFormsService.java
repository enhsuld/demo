package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkAuditForms;


public interface LnkAuditFormsService {
    public List<LnkAuditForms> find(LnkAuditForms lnkAuditForms);
    public LnkAuditForms view(LnkAuditForms lnkAuditForms);
    public void add(LnkAuditForms lnkAuditForms);
    public void edit(LnkAuditForms lnkAuditForms);
    public void remove(LnkAuditForms lnkAuditForms);
    public List<LnkAuditForms> findAll();
    public LnkAuditForms findById(String id);
    
    public List<LnkAuditForms> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
