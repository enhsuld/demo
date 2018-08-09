package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.MainAuditRegistration;


public interface MainAuditRegistrationService {
    public List<MainAuditRegistration> find(MainAuditRegistration mainAuditRegistration);
    public MainAuditRegistration view(MainAuditRegistration mainAuditRegistration);
    public void add(MainAuditRegistration mainAuditRegistration);
    public void edit(MainAuditRegistration mainAuditRegistration);
    public void remove(MainAuditRegistration mainAuditRegistration);
    public List<MainAuditRegistration> findAll();
    public MainAuditRegistration findById(String id);
    
    public List<MainAuditRegistration> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
