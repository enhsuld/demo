package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.SubAuditOrganizations;

@Mapper
public interface SubAuditOrganizationsMapper {
    public List<SubAuditOrganizations> list(SubAuditOrganizations subAuditOrganizations);
    public SubAuditOrganizations select(SubAuditOrganizations subAuditOrganizations);
    public void insert(SubAuditOrganizations subAuditOrganizations);
    public void update(SubAuditOrganizations subAuditOrganizations);
    public void delete(SubAuditOrganizations subAuditOrganizations);
    public List<SubAuditOrganizations> findAll();
    public SubAuditOrganizations findById(String id);
    
    public List<SubAuditOrganizations> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
