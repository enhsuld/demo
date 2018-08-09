package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkAuditReportsService;
import com.adt.model.LnkAuditReports;
import com.adt.dao.LnkAuditReportsMapper;

@Service
public class LnkAuditReportsServiceImpl implements LnkAuditReportsService {
    @Resource
    private LnkAuditReportsMapper LnkAuditReportsMapper;

    @Override
    public List<LnkAuditReports> find(LnkAuditReports lnkAuditReports) {
        return this.LnkAuditReportsMapper.list(lnkAuditReports);
    }

    @Override
    public LnkAuditReports view(LnkAuditReports lnkAuditReports) {
        return this.LnkAuditReportsMapper.select(lnkAuditReports);
    }
    
    @Override
    public List<LnkAuditReports> findAll() {
        return this.LnkAuditReportsMapper.findAll();
    }

    @Override
    public LnkAuditReports findById(String id) {
        return this.LnkAuditReportsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkAuditReports lnkAuditReports) {
        this.LnkAuditReportsMapper.insert(lnkAuditReports);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkAuditReports lnkAuditReports) {
        this.LnkAuditReportsMapper.update(lnkAuditReports);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkAuditReports lnkAuditReports) {
        this.LnkAuditReportsMapper.delete(lnkAuditReports);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkAuditReports> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkAuditReports>) this.LnkAuditReportsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkAuditReportsMapper.selectCount(query);
    }

}
