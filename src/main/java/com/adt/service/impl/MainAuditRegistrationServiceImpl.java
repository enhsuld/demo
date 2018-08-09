package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.MainAuditRegistrationService;
import com.adt.model.MainAuditRegistration;
import com.adt.dao.MainAuditRegistrationMapper;

@Service
public class MainAuditRegistrationServiceImpl implements MainAuditRegistrationService {
    @Resource
    private MainAuditRegistrationMapper MainAuditRegistrationMapper;

    @Override
    public List<MainAuditRegistration> find(MainAuditRegistration mainAuditRegistration) {
        return this.MainAuditRegistrationMapper.list(mainAuditRegistration);
    }

    @Override
    public MainAuditRegistration view(MainAuditRegistration mainAuditRegistration) {
        return this.MainAuditRegistrationMapper.select(mainAuditRegistration);
    }
    
    @Override
    public List<MainAuditRegistration> findAll() {
        return this.MainAuditRegistrationMapper.findAll();
    }

    @Override
    public MainAuditRegistration findById(String id) {
        return this.MainAuditRegistrationMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(MainAuditRegistration mainAuditRegistration) {
        this.MainAuditRegistrationMapper.insert(mainAuditRegistration);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(MainAuditRegistration mainAuditRegistration) {
        this.MainAuditRegistrationMapper.update(mainAuditRegistration);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(MainAuditRegistration mainAuditRegistration) {
        this.MainAuditRegistrationMapper.delete(mainAuditRegistration);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<MainAuditRegistration> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<MainAuditRegistration>) this.MainAuditRegistrationMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.MainAuditRegistrationMapper.selectCount(query);
    }

}
