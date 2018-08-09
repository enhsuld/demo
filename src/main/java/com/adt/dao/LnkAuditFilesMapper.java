package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkAuditFiles;

@Mapper
public interface LnkAuditFilesMapper {
    public List<LnkAuditFiles> list(LnkAuditFiles lnkAuditFiles);
    public LnkAuditFiles select(LnkAuditFiles lnkAuditFiles);
    public void insert(LnkAuditFiles lnkAuditFiles);
    public void update(LnkAuditFiles lnkAuditFiles);
    public void delete(LnkAuditFiles lnkAuditFiles);
    public List<LnkAuditFiles> findAll();
    public LnkAuditFiles findById(String id);
    
    public List<LnkAuditFiles> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
