package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.SubAuditOrganizations;


public interface SubAuditOrganizationsService {
    public List<SubAuditOrganizations> find(SubAuditOrganizations subAuditOrganizations);
    public SubAuditOrganizations view(SubAuditOrganizations subAuditOrganizations);
    public void add(SubAuditOrganizations subAuditOrganizations);
    public void edit(SubAuditOrganizations subAuditOrganizations);
    public void remove(SubAuditOrganizations subAuditOrganizations);
    public List<SubAuditOrganizations> findAll();
    public SubAuditOrganizations findById(String id);
    
    public List<SubAuditOrganizations> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
