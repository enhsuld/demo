package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutAuditLevel;

@Mapper
public interface LutAuditLevelMapper {
    public List<LutAuditLevel> list(LutAuditLevel lutAuditLevel);
    public LutAuditLevel select(LutAuditLevel lutAuditLevel);
    public void insert(LutAuditLevel lutAuditLevel);
    public void update(LutAuditLevel lutAuditLevel);
    public void delete(LutAuditLevel lutAuditLevel);
    public List<LutAuditLevel> findAll();
    public LutAuditLevel findById(String id);
    
    public List<LutAuditLevel> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
