package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutAuditresultsService;
import com.adt.model.LutAuditresults;
import com.adt.dao.LutAuditresultsMapper;

@Service
public class LutAuditresultsServiceImpl implements LutAuditresultsService {
    @Resource
    private LutAuditresultsMapper LutAuditresultsMapper;

    @Override
    public List<LutAuditresults> find(LutAuditresults lutAuditresults) {
        return this.LutAuditresultsMapper.list(lutAuditresults);
    }

    @Override
    public LutAuditresults view(LutAuditresults lutAuditresults) {
        return this.LutAuditresultsMapper.select(lutAuditresults);
    }
    
    @Override
    public List<LutAuditresults> findAll() {
        return this.LutAuditresultsMapper.findAll();
    }

    @Override
    public LutAuditresults findById(String id) {
        return this.LutAuditresultsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutAuditresults lutAuditresults) {
        this.LutAuditresultsMapper.insert(lutAuditresults);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutAuditresults lutAuditresults) {
        this.LutAuditresultsMapper.update(lutAuditresults);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutAuditresults lutAuditresults) {
        this.LutAuditresultsMapper.delete(lutAuditresults);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutAuditresults> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutAuditresults>) this.LutAuditresultsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutAuditresultsMapper.selectCount(query);
    }

}
