package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkAuditProblems;

@Mapper
public interface LnkAuditProblemsMapper {
    public List<LnkAuditProblems> list(LnkAuditProblems lnkAuditProblems);
    public LnkAuditProblems select(LnkAuditProblems lnkAuditProblems);
    public void insert(LnkAuditProblems lnkAuditProblems);
    public void update(LnkAuditProblems lnkAuditProblems);
    public void delete(LnkAuditProblems lnkAuditProblems);
    public List<LnkAuditProblems> findAll();
    public LnkAuditProblems findById(String id);
    
    public List<LnkAuditProblems> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
