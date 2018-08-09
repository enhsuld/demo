package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkAuditFormFileService;
import com.adt.model.LnkAuditFormFile;
import com.adt.dao.LnkAuditFormFileMapper;

@Service
public class LnkAuditFormFileServiceImpl implements LnkAuditFormFileService {
    @Resource
    private LnkAuditFormFileMapper LnkAuditFormFileMapper;

    @Override
    public List<LnkAuditFormFile> find(LnkAuditFormFile lnkAuditFormFile) {
        return this.LnkAuditFormFileMapper.list(lnkAuditFormFile);
    }

    @Override
    public LnkAuditFormFile view(LnkAuditFormFile lnkAuditFormFile) {
        return this.LnkAuditFormFileMapper.select(lnkAuditFormFile);
    }
    
    @Override
    public List<LnkAuditFormFile> findAll() {
        return this.LnkAuditFormFileMapper.findAll();
    }

    @Override
    public LnkAuditFormFile findById(String id) {
        return this.LnkAuditFormFileMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkAuditFormFile lnkAuditFormFile) {
        this.LnkAuditFormFileMapper.insert(lnkAuditFormFile);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkAuditFormFile lnkAuditFormFile) {
        this.LnkAuditFormFileMapper.update(lnkAuditFormFile);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkAuditFormFile lnkAuditFormFile) {
        this.LnkAuditFormFileMapper.delete(lnkAuditFormFile);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkAuditFormFile> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkAuditFormFile>) this.LnkAuditFormFileMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkAuditFormFileMapper.selectCount(query);
    }

}
