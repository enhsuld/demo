package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkAuditFormFile;

@Mapper
public interface LnkAuditFormFileMapper {
    public List<LnkAuditFormFile> list(LnkAuditFormFile lnkAuditFormFile);
    public LnkAuditFormFile select(LnkAuditFormFile lnkAuditFormFile);
    public void insert(LnkAuditFormFile lnkAuditFormFile);
    public void update(LnkAuditFormFile lnkAuditFormFile);
    public void delete(LnkAuditFormFile lnkAuditFormFile);
    public List<LnkAuditFormFile> findAll();
    public LnkAuditFormFile findById(String id);
    
    public List<LnkAuditFormFile> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
