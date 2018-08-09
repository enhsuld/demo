package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutAuditresults;

@Mapper
public interface LutAuditresultsMapper {
    public List<LutAuditresults> list(LutAuditresults lutAuditresults);
    public LutAuditresults select(LutAuditresults lutAuditresults);
    public void insert(LutAuditresults lutAuditresults);
    public void update(LutAuditresults lutAuditresults);
    public void delete(LutAuditresults lutAuditresults);
    public List<LutAuditresults> findAll();
    public LutAuditresults findById(String id);
    
    public List<LutAuditresults> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
