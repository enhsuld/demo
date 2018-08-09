package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.MainAuditRegistration;

@Mapper
public interface MainAuditRegistrationMapper {
    public List<MainAuditRegistration> list(MainAuditRegistration mainAuditRegistration);
    public MainAuditRegistration select(MainAuditRegistration mainAuditRegistration);
    public void insert(MainAuditRegistration mainAuditRegistration);
    public void update(MainAuditRegistration mainAuditRegistration);
    public void delete(MainAuditRegistration mainAuditRegistration);
    public List<MainAuditRegistration> findAll();
    public MainAuditRegistration findById(String id);
    
    public List<MainAuditRegistration> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
