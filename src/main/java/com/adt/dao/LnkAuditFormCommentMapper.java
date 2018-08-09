package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkAuditFormComment;

@Mapper
public interface LnkAuditFormCommentMapper {
    public List<LnkAuditFormComment> list(LnkAuditFormComment lnkAuditFormComment);
    public LnkAuditFormComment select(LnkAuditFormComment lnkAuditFormComment);
    public void insert(LnkAuditFormComment lnkAuditFormComment);
    public void update(LnkAuditFormComment lnkAuditFormComment);
    public void delete(LnkAuditFormComment lnkAuditFormComment);
    public List<LnkAuditFormComment> findAll();
    public LnkAuditFormComment findById(String id);
    
    public List<LnkAuditFormComment> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
