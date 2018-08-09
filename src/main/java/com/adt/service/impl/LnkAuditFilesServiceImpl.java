package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkAuditFilesService;
import com.adt.model.LnkAuditFiles;
import com.adt.dao.LnkAuditFilesMapper;

@Service
public class LnkAuditFilesServiceImpl implements LnkAuditFilesService {
    @Resource
    private LnkAuditFilesMapper LnkAuditFilesMapper;

    @Override
    public List<LnkAuditFiles> find(LnkAuditFiles lnkAuditFiles) {
        return this.LnkAuditFilesMapper.list(lnkAuditFiles);
    }

    @Override
    public LnkAuditFiles view(LnkAuditFiles lnkAuditFiles) {
        return this.LnkAuditFilesMapper.select(lnkAuditFiles);
    }
    
    @Override
    public List<LnkAuditFiles> findAll() {
        return this.LnkAuditFilesMapper.findAll();
    }

    @Override
    public LnkAuditFiles findById(String id) {
        return this.LnkAuditFilesMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkAuditFiles lnkAuditFiles) {
        this.LnkAuditFilesMapper.insert(lnkAuditFiles);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkAuditFiles lnkAuditFiles) {
        this.LnkAuditFilesMapper.update(lnkAuditFiles);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkAuditFiles lnkAuditFiles) {
        this.LnkAuditFilesMapper.delete(lnkAuditFiles);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkAuditFiles> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkAuditFiles>) this.LnkAuditFilesMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkAuditFilesMapper.selectCount(query);
    }

}
