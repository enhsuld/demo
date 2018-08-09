package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkAuditProblemsService;
import com.adt.model.LnkAuditProblems;
import com.adt.dao.LnkAuditProblemsMapper;

@Service
public class LnkAuditProblemsServiceImpl implements LnkAuditProblemsService {
    @Resource
    private LnkAuditProblemsMapper LnkAuditProblemsMapper;

    @Override
    public List<LnkAuditProblems> find(LnkAuditProblems lnkAuditProblems) {
        return this.LnkAuditProblemsMapper.list(lnkAuditProblems);
    }

    @Override
    public LnkAuditProblems view(LnkAuditProblems lnkAuditProblems) {
        return this.LnkAuditProblemsMapper.select(lnkAuditProblems);
    }
    
    @Override
    public List<LnkAuditProblems> findAll() {
        return this.LnkAuditProblemsMapper.findAll();
    }

    @Override
    public LnkAuditProblems findById(String id) {
        return this.LnkAuditProblemsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkAuditProblems lnkAuditProblems) {
        this.LnkAuditProblemsMapper.insert(lnkAuditProblems);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkAuditProblems lnkAuditProblems) {
        this.LnkAuditProblemsMapper.update(lnkAuditProblems);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkAuditProblems lnkAuditProblems) {
        this.LnkAuditProblemsMapper.delete(lnkAuditProblems);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkAuditProblems> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkAuditProblems>) this.LnkAuditProblemsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkAuditProblemsMapper.selectCount(query);
    }

}
