package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutAuditLevelService;
import com.adt.model.LutAuditLevel;
import com.adt.dao.LutAuditLevelMapper;

@Service
public class LutAuditLevelServiceImpl implements LutAuditLevelService {
    @Resource
    private LutAuditLevelMapper LutAuditLevelMapper;

    @Override
    public List<LutAuditLevel> find(LutAuditLevel lutAuditLevel) {
        return this.LutAuditLevelMapper.list(lutAuditLevel);
    }

    @Override
    public LutAuditLevel view(LutAuditLevel lutAuditLevel) {
        return this.LutAuditLevelMapper.select(lutAuditLevel);
    }
    
    @Override
    public List<LutAuditLevel> findAll() {
        return this.LutAuditLevelMapper.findAll();
    }

    @Override
    public LutAuditLevel findById(String id) {
        return this.LutAuditLevelMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutAuditLevel lutAuditLevel) {
        this.LutAuditLevelMapper.insert(lutAuditLevel);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutAuditLevel lutAuditLevel) {
        this.LutAuditLevelMapper.update(lutAuditLevel);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutAuditLevel lutAuditLevel) {
        this.LutAuditLevelMapper.delete(lutAuditLevel);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutAuditLevel> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutAuditLevel>) this.LutAuditLevelMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutAuditLevelMapper.selectCount(query);
    }

}
