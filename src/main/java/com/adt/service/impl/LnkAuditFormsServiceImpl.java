package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkAuditFormsService;
import com.adt.model.LnkAuditForms;
import com.adt.dao.LnkAuditFormsMapper;

@Service
public class LnkAuditFormsServiceImpl implements LnkAuditFormsService {
    @Resource
    private LnkAuditFormsMapper LnkAuditFormsMapper;

    @Override
    public List<LnkAuditForms> find(LnkAuditForms lnkAuditForms) {
        return this.LnkAuditFormsMapper.list(lnkAuditForms);
    }

    @Override
    public LnkAuditForms view(LnkAuditForms lnkAuditForms) {
        return this.LnkAuditFormsMapper.select(lnkAuditForms);
    }
    
    @Override
    public List<LnkAuditForms> findAll() {
        return this.LnkAuditFormsMapper.findAll();
    }

    @Override
    public LnkAuditForms findById(String id) {
        return this.LnkAuditFormsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkAuditForms lnkAuditForms) {
        this.LnkAuditFormsMapper.insert(lnkAuditForms);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkAuditForms lnkAuditForms) {
        this.LnkAuditFormsMapper.update(lnkAuditForms);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkAuditForms lnkAuditForms) {
        this.LnkAuditFormsMapper.delete(lnkAuditForms);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkAuditForms> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkAuditForms>) this.LnkAuditFormsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkAuditFormsMapper.selectCount(query);
    }

}
