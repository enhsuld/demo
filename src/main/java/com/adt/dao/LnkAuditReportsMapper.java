package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkAuditReports;

@Mapper
public interface LnkAuditReportsMapper {
    public List<LnkAuditReports> list(LnkAuditReports lnkAuditReports);
    public LnkAuditReports select(LnkAuditReports lnkAuditReports);
    public void insert(LnkAuditReports lnkAuditReports);
    public void update(LnkAuditReports lnkAuditReports);
    public void delete(LnkAuditReports lnkAuditReports);
    public List<LnkAuditReports> findAll();
    public LnkAuditReports findById(String id);
    
    public List<LnkAuditReports> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
