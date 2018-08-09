package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkAuditForms;

@Mapper
public interface LnkAuditFormsMapper {
    public List<LnkAuditForms> list(LnkAuditForms lnkAuditForms);
    public LnkAuditForms select(LnkAuditForms lnkAuditForms);
    public void insert(LnkAuditForms lnkAuditForms);
    public void update(LnkAuditForms lnkAuditForms);
    public void delete(LnkAuditForms lnkAuditForms);
    public List<LnkAuditForms> findAll();
    public LnkAuditForms findById(String id);
    
    public List<LnkAuditForms> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
